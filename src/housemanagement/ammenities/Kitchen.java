package housemanagement.ammenities;

import housemanagement.commands.Command;

public class Kitchen {

    private Command cleanCommand; // if we nmake it final we need to initialize it via constructor only.
    private Command toggleCommand;

    public void setCommand(Command cleanCommand, Command toggleCommand){
        this.cleanCommand = cleanCommand;
        this.toggleCommand = toggleCommand;
    }

    public void startKitchenCleaning(){

        cleanCommand.execute();
    }

    public void toggleLight(){
        toggleCommand.execute();
    }
}
