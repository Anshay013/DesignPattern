package elevator;

import elevator.dispatcher.internalButton.InternalButton;

public class ElevatorCar {

    private InternalButton button;

    public ElevatorCar( InternalButton button){
        this.button =  button;
    }

    public void clickButton(int currentFloor, int goToFloor){
        button.setCurrentFloor(currentFloor);
        button.PressInternalButton(goToFloor);
    }






}
