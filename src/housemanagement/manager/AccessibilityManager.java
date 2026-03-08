package housemanagement.manager;

import command.commanditem.Light;

public class AccessibilityManager extends WorkManager{


    private final Light light;
    public AccessibilityManager(Light light) {
        this.light = light;
    }

    @Override
    public void doWork() {
        super.doWork();
        light.toggleLight();
    }
}
