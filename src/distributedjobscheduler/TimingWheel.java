
package distributedjobscheduler;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

class TimingWheel {
    private final int tickDurationMs;
    private final int wheelSize;
    private final List<JobMetaData>[] buckets;
    private final ReentrantLock lock = new ReentrantLock();
    private int currentTickIndex = 0;

    @SuppressWarnings("unchecked")
    public TimingWheel(int tickDurationMs, int wheelSize) {
        this.tickDurationMs = tickDurationMs;
        this.wheelSize = wheelSize;
        this.buckets = new List[wheelSize];
        for (int i = 0; i < wheelSize; i++) {
            buckets[i] = new ArrayList<>();
        }
        System.out.println("TimingWheel: Initialized with tickDurationMs=" + tickDurationMs + ", wheelSize=" + wheelSize);
    }

    public void addJob(JobMetaData job) {
        lock.lock();
        try {
            long delay = job.getExecutionTimeMs() - System.currentTimeMillis();
            if (delay < 0) delay = 0;

            long ticks = delay / tickDurationMs;
            int targetIndex = (int) ((currentTickIndex + ticks) % wheelSize);

            buckets[targetIndex].add(job);
            job.transitionToSchedule();
            System.out.println("[TIMING WHEEL] Scheduled Job " + job.getJobId() + " in slot " + targetIndex);
            System.out.println("TimingWheel: Added job " + job.getJobId() + " to bucket " + targetIndex);
        } finally {
            lock.unlock();
        }
    }

    public List<JobMetaData> advanceTick() {
        lock.lock();
        try {
            System.out.println("TimingWheel: Advancing tick to " + currentTickIndex);
            List<JobMetaData> jobsToExecute = new ArrayList<>(buckets[currentTickIndex]);
            buckets[currentTickIndex].clear();
            currentTickIndex = (currentTickIndex + 1) % wheelSize;
            if (!jobsToExecute.isEmpty()) {
                System.out.println("TimingWheel: Found " + jobsToExecute.size() + " jobs to execute.");
            }
            return jobsToExecute;
        } finally {
            lock.unlock();
        }
    }
}
