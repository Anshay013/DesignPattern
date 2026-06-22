package distributedjobscheduler;

import java.util.Map;

enum JobStatus { CREATED, SCHEDULED, RUNNING, SUCCESS, FAILED }

// Exceptions for transition guards
class InvalidStateTransitionException extends RuntimeException {
    public InvalidStateTransitionException(String msg) { super(msg); }
}

// State interface managing lifecycle mutations
interface JobState {
    void schedule(JobMetaData context);
    void run(JobMetaData context);
    void success(JobMetaData context);
    void fail(JobMetaData context);
    JobStatus getStatus();
}

// Context Metadata class wrapping variables and the active mutable state
class JobMetaData {
    private final String jobId;
    private final String jobType;
    private final Map<String, Object> params;
    private JobState currentState;

    private final int maxRetries = 3;
    private int currentRetryCount = 0;
    private long executionTimeMs;

    public JobMetaData(String jobId, String jobType, Map<String, Object> params, long delayFromNowMs) {
        this.jobId = jobId;
        this.jobType = jobType;
        this.params = params;
        this.executionTimeMs = System.currentTimeMillis() + delayFromNowMs;
        this.currentState = new CreatedState();
    }

    // State Mutation Methods
    public synchronized void transitionToSchedule() { currentState.schedule(this); }
    public synchronized void transitionToRun() { currentState.run(this); }
    public synchronized void transitionToSuccess() { currentState.success(this); }
    public synchronized void transitionToFail() { currentState.fail(this); }

    // Getters and Setters
    protected void setState(JobState state) { this.currentState = state; }
    public JobStatus getStatus() { return currentState.getStatus(); }
    public String getJobId() { return jobId; }
    public String getJobType() { return jobType; }
    public Map<String, Object> getParams() { return params; }
    public long getExecutionTimeMs() { return executionTimeMs; }
    public void setExecutionTimeMs(long time) { this.executionTimeMs = time; }
    public int getCurrentRetryCount() { return currentRetryCount; }
    public void incrementRetry() { this.currentRetryCount++; }
    public int getMaxRetries() { return maxRetries; }
}

// Concrete States with Transition Guards
class CreatedState implements JobState {
    @Override public void schedule(JobMetaData ctx) { ctx.setState(new ScheduledState()); }
    @Override public void run(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot run from CREATED"); }
    @Override public void success(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot succeed from CREATED"); }
    @Override public void fail(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot fail from CREATED"); }
    @Override public JobStatus getStatus() { return JobStatus.CREATED; }
}

class ScheduledState implements JobState {
    @Override public void schedule(JobMetaData ctx) { /* Already scheduled */ }
    @Override public void run(JobMetaData ctx) { ctx.setState(new RunningState()); }
    @Override public void success(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot succeed from SCHEDULED"); }
    @Override public void fail(JobMetaData ctx) { ctx.setState(new FailedState()); }
    @Override public JobStatus getStatus() { return JobStatus.SCHEDULED; }
}

class RunningState implements JobState {
    @Override public void schedule(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot reschedule a RUNNING job"); }
    @Override public void run(JobMetaData ctx) { throw new InvalidStateTransitionException("Already RUNNING"); }
    @Override public void success(JobMetaData ctx) { ctx.setState(new SuccessState()); }
    @Override public void fail(JobMetaData ctx) { ctx.setState(new FailedState()); }
    @Override public JobStatus getStatus() { return JobStatus.RUNNING; }
}

class SuccessState implements JobState {
    @Override public void schedule(JobMetaData ctx) { throw new InvalidStateTransitionException("Terminal State"); }
    @Override public void run(JobMetaData ctx) { throw new InvalidStateTransitionException("Terminal State"); }
    @Override public void success(JobMetaData ctx) {}
    @Override public void fail(JobMetaData ctx) { throw new InvalidStateTransitionException("Terminal State"); }
    @Override public JobStatus getStatus() { return JobStatus.SUCCESS; }
}

class FailedState implements JobState {
    @Override public void schedule(JobMetaData ctx) { ctx.setState(new ScheduledState()); } // For retries
    @Override public void run(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot run from FAILED"); }
    @Override public void success(JobMetaData ctx) { throw new InvalidStateTransitionException("Cannot succeed from FAILED"); }
    @Override public void fail(JobMetaData ctx) {}
    @Override public JobStatus getStatus() { return JobStatus.FAILED; }
}
