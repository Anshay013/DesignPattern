
package distributedjobscheduler;

import distributedjobscheduler.backoffstrategy.BackoffStrategy;
import distributedjobscheduler.backoffstrategy.ExponentialBackoff;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class JobWorkerPool {
    private final ThreadPoolExecutor executor;
    private final BackoffStrategy backoffStrategy = new ExponentialBackoff(1000); // 1s base

    public JobWorkerPool(int coreSize, int maxSize, int queueCapacity) {
        // Bounded implementation prevents crashing on traffic bursts
        this.executor = new ThreadPoolExecutor(
                coreSize, maxSize, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy() // Backpressure protection
        );
        System.out.println("JobWorkerPool: Initialized with coreSize=" + coreSize + ", maxSize=" + maxSize + ", queueCapacity=" + queueCapacity);
    }

    public void submit(JobMetaData job, TimingWheel wheel) {
        System.out.println("JobWorkerPool: Submitting job " + job.getJobId());
        executor.submit(() -> {
            try {
                job.transitionToRun();
                JobCommand command = CommandFactory.getCommand(job.getJobType());
                JobContext context = new JobContext(job.getJobId(), job.getParams());

                System.out.println("JobWorkerPool: Executing job " + job.getJobId());
                command.execute(context);
                job.transitionToSuccess();
                System.out.println("[WORKER] Job completed successfully: " + job.getJobId());
            } catch (Exception e) {
                System.err.println("[WORKER] Execution failed for job: " + job.getJobId() + " - " + e.getMessage());
                handleFailure(job, wheel);
            }
        });
    }

    private void handleFailure(JobMetaData job, TimingWheel wheel) {
        job.transitionToFail();
        if (job.getCurrentRetryCount() < job.getMaxRetries()) {
            job.incrementRetry();
            long delay = backoffStrategy.calculateDelay(job.getCurrentRetryCount());
            job.setExecutionTimeMs(System.currentTimeMillis() + delay);

            System.out.println("[RETRY ENGINE] Re-scheduling job " + job.getJobId() + " Retry #" + job.getCurrentRetryCount() + " with delay " + delay + "ms");
            wheel.addJob(job);
        } else {
            System.err.println("[RETRY ENGINE] Job " + job.getJobId() + " failed permanently after maximum retries.");
        }
    }

    public void shutdown() {
        System.out.println("JobWorkerPool: Shutting down.");
        executor.shutdown();
    }
}
