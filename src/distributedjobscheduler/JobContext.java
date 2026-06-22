package distributedjobscheduler;

import java.util.Map;

// Context passed to jobs during execution
class JobContext {
    private final String jobId;
    private final Map<String, Object> metadata;

    public JobContext(String jobId, Map<String, Object> metadata) {
        this.jobId = jobId;
        this.metadata = metadata;
    }
    public String getJobId() { return jobId; }
    public Object getParam(String key) { return metadata.get(key); }
}
