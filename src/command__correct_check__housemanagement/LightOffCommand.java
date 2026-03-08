package command__correct_check__housemanagement;

import command__correct_check__housemanagement.commanditem.Light;

public class LightOffCommand extends Command{

    private Light light;

    public LightOffCommand(Light light) {
        super(light);
        this.light = light;
        System.out.println("Execute Command Off");
    }

    @Override
    public void execute() {
        light.Off();
    }
}
