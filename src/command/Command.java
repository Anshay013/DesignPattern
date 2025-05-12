package command;

import command.commanditem.Light;

public abstract class Command {

    public Command(Light light){
        System.out.println("Init Command");
    }

    public abstract void execute();
}
