package elevator.dispatcher.externalButton;

import elevator.Direction;
import elevator.controller.ElevatorController;

public abstract class ExternalButtonDispatcher {

    public ExternalButtonDispatcher(ElevatorController controller){
    }

    public void takeAction(int floor, Direction dir){
        System.out.println("Dispatching the elevator");
    }


}

