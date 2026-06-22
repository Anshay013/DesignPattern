package distributedjobscheduler;


// Command Interface
interface JobCommand {
    void execute(JobContext context) throws Exception;
}

// Concrete Command 1
class EmailJobCommand implements JobCommand {
    @Override
    public void execute(JobContext context) throws Exception {
        System.out.println("[EXECUTE] Sending email for Job: " + context.getJobId() + " to: " + context.getParam("email"));
    }
}

// Concrete Command 2
class VideoProcessingJobCommand implements JobCommand {
    @Override
    public void execute(JobContext context) throws Exception {
        System.out.println("[EXECUTE] Transcoding video for Job: " + context.getJobId() + " path: " + context.getParam("videoPath"));
    }
}


