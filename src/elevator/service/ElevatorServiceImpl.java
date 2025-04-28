package elevator.service;

import elevator.ElevatorCar;
import elevator.createService.CreateServiceFactory;
import elevator.dispatcher.externalButton.ExternalButton;

public class ElevatorServiceImpl extends ElevatorService{

    private CreateServiceFactory serviceFactory;
    public ElevatorServiceImpl(CreateServiceFactory serviceFactory) {
        super(serviceFactory);
        this.serviceFactory = serviceFactory;
    }

    @Override
    public ExternalButton callElevatorService() {
          return (ExternalButton) serviceFactory.getServiceObject("EXTERNAL_SWITCH_ODD_EVEN");
    }

    @Override
    public ElevatorCar reachDestinationService() {
        return (ElevatorCar) serviceFactory.getServiceObject("ELEVATOR_CAR");
    }
}
