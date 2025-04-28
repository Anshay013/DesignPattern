package elevator.service;

import elevator.ElevatorCar;
import elevator.createService.CreateServiceFactory;
import elevator.dispatcher.externalButton.ExternalButton;

public abstract class ElevatorService {

    public ElevatorService(CreateServiceFactory serviceFactory){
        System.out.println("create service object");
    }

     public abstract ExternalButton callElevatorService();
     public abstract ElevatorCar reachDestinationService();


}
