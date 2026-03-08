package housemanagement;

import housemanagement.ammenities.Kitchen;
import housemanagement.commands.Command;

public class HouseDriver {

    public static void main(String[] args) {


        // make a command fist.
        // then make a kitchen object and call its setCommand by passing this command.
        // after call kitchenCleaning fun via kitchen object.

        Command kitchenAccessibilityCommand = CommandFactory.getCommand(CommandConstants.ACCESSIBILITY_COMMAND);
        Command kitchenCleanCommand = CommandFactory.getCommand(CommandConstants.CLEANING_COMMAND);

        Kitchen kitchen = new Kitchen();
        kitchen.setCommand(kitchenCleanCommand, kitchenAccessibilityCommand);
        kitchen.startKitchenCleaning();
        System.out.println();
        kitchen.toggleLight();



    }
}
