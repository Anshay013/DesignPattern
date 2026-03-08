package housemanagement;

import command.commanditem.Light;
import housemanagement.commands.AccessibilityCommand;
import housemanagement.commands.CleanCommand;
import housemanagement.commands.Command;
import housemanagement.commands.CookingCommand;
import housemanagement.manager.AccessibilityManager;
import housemanagement.manager.CleaningManager;
import housemanagement.manager.CookingManager;
import org.jetbrains.annotations.NotNull;


public class CommandFactory {

    // this is not singleton, if you want we can make it singleton directly to class.
    public static Command getCommand(@NotNull String input) {
        switch (input) {
            case CommandConstants.COOKING_COMMAND -> {
                return new CookingCommand(new CookingManager());
            }
            case CommandConstants.CLEANING_COMMAND -> {
                return new CleanCommand(new CleaningManager());
            }
            case CommandConstants.ACCESSIBILITY_COMMAND ->{
                return new AccessibilityCommand(new AccessibilityManager(new Light()));
            }
            default -> {
                System.out.println("Illegal Command thrown");
            }
        }
        return null;
    }

}
