package distributedjobscheduler.backoffstrategy;



// Strategy Implementation 1
class LinearBackoff implements BackoffStrategy {
    private final long baseDelayMs;
    public LinearBackoff(long baseDelayMs) { this.baseDelayMs = baseDelayMs; }

    @Override
    public long calculateDelay(int retryCount) {
        return baseDelayMs * retryCount;
    }
}

