package elevator.dispatcher.internalButton;

import elevator.Direction;
import elevator.controller.ElevatorController;

public abstract class InternalButtonDispatcher {

    public InternalButtonDispatcher(ElevatorController controller){
        System.out.println("Dispatching elevator via Internal Button");
    }

    public void takeAction(int floor, Direction dir){
        System.out.println("Doors are closing please keep clear");
    }

}
