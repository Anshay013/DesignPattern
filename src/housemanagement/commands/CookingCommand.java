package housemanagement.commands;

import housemanagement.manager.WorkManager;

public class CookingCommand implements Command {

    private final WorkManager workManager;

    public CookingCommand(WorkManager workManager){
        this.workManager = workManager;
    }

    @Override
    public void execute() {
        workManager.doWork();
    }
}
