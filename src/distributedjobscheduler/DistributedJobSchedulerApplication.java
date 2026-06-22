
package distributedjobscheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributedJobSchedulerApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("DistributedJobSchedulerApplication: Starting application.");
        // 1. Initialize core system
        TimingWheel wheel = new TimingWheel(100, 60); // 100ms ticks, 60 slots
        JobWorkerPool workerPool = new JobWorkerPool(2, 4, 10);

        // 2. Mock payload configurations
        Map<String, Object> emailMeta = new HashMap<>();
        emailMeta.put("email", "candidate@interview.com");

        Map<String, Object> videoMeta = new HashMap<>();
        videoMeta.put("videoPath", "/var/storage/movie.mp4");

        // 3. Inject explicit sample test jobs
        JobMetaData job1 = new JobMetaData("JOB-101", "EMAIL", emailMeta, 200);  // execute in 200ms
        JobMetaData job2 = new JobMetaData("JOB-102", "VIDEO", videoMeta, 500);  // execute in 500ms

        System.out.println("DistributedJobSchedulerApplication: Adding jobs to the timing wheel.");
        wheel.addJob(job1);
        wheel.addJob(job2);

        // 4. Run Ticker processing engine loop concurrently
        Thread tickerThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(100); // Represents the clock hardware interval
                    System.out.println("DistributedJobSchedulerApplication: Ticker thread running.");
                    List<JobMetaData> readyJobs = wheel.advanceTick();
                    for (JobMetaData job : readyJobs) {
                        System.out.println("DistributedJobSchedulerApplication: Submitting job " + job.getJobId() + " to the worker pool.");
                        workerPool.submit(job, wheel);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Ticker loop safely offline.");
            }
        });

        System.out.println("DistributedJobSchedulerApplication: Starting ticker thread.");
        tickerThread.start();

        // Let execution cycle through for demonstration windows
        Thread.sleep(2000);

        System.out.println("DistributedJobSchedulerApplication: Interrupting ticker thread and shutting down worker pool.");
        tickerThread.interrupt();
        workerPool.shutdown();
        System.out.println("DistributedJobSchedulerApplication: Application finished.");
    }
}
