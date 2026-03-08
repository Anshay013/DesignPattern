package housemanagement.commands;

import housemanagement.manager.WorkManager;

public class CleanCommand implements Command {


    private final WorkManager workManager;

    public CleanCommand(WorkManager workManager){
        this.workManager = workManager;
    }


    @Override
    public void execute() {
        workManager.doWork();
    }
}
