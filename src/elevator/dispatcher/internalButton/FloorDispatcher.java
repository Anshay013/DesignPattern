package elevator.dispatcher.internalButton;

import elevator.Direction;
import elevator.controller.ElevatorController;

public class FloorDispatcher extends InternalButtonDispatcher{

    private ElevatorController controller;

    public FloorDispatcher(ElevatorController controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    public void takeAction(int floor, Direction dir){
        System.out.println("Dispatching the elevator");
        controller.submitButtonInternalButton(floor, dir);
    }
}
