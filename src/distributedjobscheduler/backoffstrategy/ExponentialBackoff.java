package distributedjobscheduler.backoffstrategy;

// Strategy Implementation 2
public class ExponentialBackoff implements BackoffStrategy {
    private final long baseDelayMs;
    public ExponentialBackoff(long baseDelayMs) { this.baseDelayMs = baseDelayMs; }

    @Override
    public long calculateDelay(int retryCount) {
        return baseDelayMs * (long) Math.pow(2, retryCount - 1);
    }
}
