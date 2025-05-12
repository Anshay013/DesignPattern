package command;

import command.commanditem.Light;

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
