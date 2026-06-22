package distributedjobscheduler.backoffstrategy;

// Strategy Interface
public interface BackoffStrategy {
    long calculateDelay(int retryCount);
}
