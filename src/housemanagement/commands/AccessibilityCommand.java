package housemanagement.commands;

import housemanagement.manager.WorkManager;

public class AccessibilityCommand implements Command {


    private final WorkManager workManager;

    public AccessibilityCommand(WorkManager workManager){
        this.workManager = workManager;
    }


    @Override
    public void execute() {
        workManager.doWork();
    }
}
