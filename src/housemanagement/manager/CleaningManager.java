package housemanagement.manager;

import housemanagement.commands.CleanCommand;

public class CleaningManager extends WorkManager{


    @Override
    public void doWork() {
        super.doWork();
        System.out.println("start cleaning");

    }
}
