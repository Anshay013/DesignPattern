package elevator.controller;

import elevator.Direction;

public class ElevatorControllerImpl implements ElevatorController {

    @Override
    public void submitRequestExternalButton(int floor, Direction dir) {
        System.out.println("request submitted elevator on the way");
        // my logic
    }

    @Override
    public void submitButtonInternalButton(int floor, Direction dir) {
        System.out.println("request submitted, on your way to reach the destination");
        // my logic
    }
}
