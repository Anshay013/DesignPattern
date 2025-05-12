package command.service;

import command.Command;

public class LightExecuterService extends ServiceExecuter {

    private Command command;

    public LightExecuterService(Command command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(){
        command.execute();
    }

}
