package elevator.dispatcher.externalButton;

import elevator.Direction;
import elevator.controller.ElevatorController;

public class OddEvenDispatcher extends ExternalButtonDispatcher {

    private ElevatorController controller;

    public OddEvenDispatcher(ElevatorController controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    public void takeAction(int floor, Direction dir){
        super.takeAction(floor, dir);
        System.out.println("go to floor and dir");
        // any implementation that we want to do..
        controller.submitRequestExternalButton(floor, dir);
    }
}
