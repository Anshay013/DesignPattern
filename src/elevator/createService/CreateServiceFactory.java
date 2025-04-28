package elevator.createService;

import elevator.ElevatorCar;
import elevator.controller.ElevatorControllerImpl;
import elevator.dispatcher.externalButton.ExternalButton;
import elevator.dispatcher.externalButton.ExternalButtonDispatcher;
import elevator.dispatcher.externalButton.OddEvenDispatcher;
import elevator.dispatcher.internalButton.FloorDispatcher;
import elevator.dispatcher.internalButton.InternalButton;
import org.jetbrains.annotations.NotNull;

public  class CreateServiceFactory {

    public Object getServiceObject(@NotNull String serviceName){

        switch (serviceName)  {
            case "EXTERNAL_SWITCH_ODD_EVEN"-> {
                return new ExternalButton(new OddEvenDispatcher(new ElevatorControllerImpl()));
            }
            case "ELEVATOR_CAR" ->{
                return new ElevatorCar(new InternalButton(new FloorDispatcher(new ElevatorControllerImpl())));
            }
            default -> {
                return null;
            }
        }
    }


}
