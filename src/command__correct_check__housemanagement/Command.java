package command__correct_check__housemanagement;

import command__correct_check__housemanagement.commanditem.Light;

public abstract class Command {

    public Command(Light light){
        System.out.println("Init Command");
    }

    public abstract void execute();
}
