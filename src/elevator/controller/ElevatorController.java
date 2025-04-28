package elevator.controller;

import elevator.Direction;

public interface ElevatorController {

    void submitRequestExternalButton(int floor, Direction dir);
    void submitButtonInternalButton(int floor, Direction dir);
}
