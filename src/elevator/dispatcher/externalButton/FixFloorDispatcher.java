package elevator.dispatcher.externalButton;

import elevator.Direction;
import elevator.controller.ElevatorController;

public class FixFloorDispatcher extends ExternalButtonDispatcher {

    private  ElevatorController controller;

    public FixFloorDispatcher(ElevatorController controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    public void takeAction(int floor, Direction dir){
        super.takeAction(floor, dir);
        System.out.println("fix floor strategy, elevator coming to you");

        // any implementation that we want to do
        controller.submitRequestExternalButton(floor, dir);
    }
}
