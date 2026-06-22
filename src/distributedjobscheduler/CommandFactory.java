package distributedjobscheduler;

import java.util.HashMap;
import java.util.Map;

// Factory Pattern to register and look up commands
class CommandFactory {
    private static final Map<String, JobCommand> registry = new HashMap<>();

    static {
        registry.put("EMAIL", new EmailJobCommand());
        registry.put("VIDEO", new VideoProcessingJobCommand());
    }

    public static JobCommand getCommand(String type) {
        JobCommand cmd = registry.get(type);
        if (cmd == null) throw new IllegalArgumentException("Unknown job type: " + type);
        return cmd;
    }
}
