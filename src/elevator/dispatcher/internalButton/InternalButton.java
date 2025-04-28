package elevator.dispatcher.internalButton;

import elevator.Direction;

public class InternalButton {

    private InternalButtonDispatcher dispatcher;
    private int currentFloor;

    public InternalButton(InternalButtonDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    public void setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void PressInternalButton(int goToFloor) {
        int floor = getCurrentFloor();
        Direction dir = getCurrentFloor() > goToFloor ? Direction.DOWN : (currentFloor <  goToFloor ? Direction.UP : Direction.INVALID);
        dispatcher.takeAction(goToFloor, dir);

    }


}
