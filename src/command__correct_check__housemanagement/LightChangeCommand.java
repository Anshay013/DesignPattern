package command__correct_check__housemanagement;

import command__correct_check__housemanagement.commanditem.Light;

import java.awt.*;

public class LightChangeCommand extends Command{

    private Light light;
    private Color color;

    public LightChangeCommand(Light light, Color color) {
        super(light);
        this.light = light;
        this.color = color;
        System.out.println("Execute Command Change");
    }

    @Override
    public void execute() {
        light.changeColor(color);
    }
}
