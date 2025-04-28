package elevator.dispatcher.externalButton;

import elevator.Direction;

public class ExternalButton {

    private ExternalButtonDispatcher dispatcher;
    private int currentFloor;


    public ExternalButton(ExternalButtonDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    public void setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void pressExternalButton(Direction dir){
        dispatcher.takeAction(getCurrentFloor(), dir);
    }

}
