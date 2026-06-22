
package distributedjobscheduler.backoffstrategy;

import java.util.concurrent.ThreadLocalRandom;

public class ExponentialBackoffWithJitter implements BackoffStrategy {
    private final long baseDelay;
    private final long maxDelay;

    public ExponentialBackoffWithJitter(long baseDelay, long maxDelay) {
        this.baseDelay = baseDelay;
        this.maxDelay = maxDelay;
        System.out.println("ExponentialBackoffWithJitter: Initialized with baseDelay=" + baseDelay + ", maxDelay=" + maxDelay);
    }

    @Override
    public long calculateDelay(int retryCount) {
        long delay = (long) (baseDelay * Math.pow(2, retryCount));
        delay = Math.min(delay, maxDelay);
        long jitter = ThreadLocalRandom.current().nextLong(delay / 10);
        System.out.println("ExponentialBackoffWithJitter: Calculated delay for retry " + retryCount + " is " + (delay + jitter) + "ms (delay=" + delay + ", jitter=" + jitter + ")");
        return delay + jitter;
    }
}
