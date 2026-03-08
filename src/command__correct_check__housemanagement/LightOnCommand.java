package command__correct_check__housemanagement;

import command__correct_check__housemanagement.commanditem.Light;

public class LightOnCommand extends Command{

    private Light light;

    public LightOnCommand(Light light) {
        super(light);
        this.light = light;
        System.out.println("Execute Command Onn");
    }

    @Override
    public void execute() {
        light.Onn();
    }
}
