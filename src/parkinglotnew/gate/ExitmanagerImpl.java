package parkinglotnew.gate;

import parkinglotnew.Floor;
import parkinglotnew.model.Parking;
import parkinglotnew.model.Vehicle;
import parkinglotnew.paymentservice.PaymentService;

public class ExitmanagerImpl extends ExitGateManager{

    private  PaymentService paymentService;

    public ExitmanagerImpl(PaymentService paymentService){
        super();
        this.paymentService = paymentService;
    }

    @Override
    public void vehilceExit(Vehicle vehicle){

        Floor floor = vehicle.getFloor();
        Parking parking = vehicle.getParking();
        floor.getParkingLotList(vehicle.getVehicleType())
                .set(parking.getParkingNo(), new Parking(parking.getParkingNo(), floor.getFloorNo(), null, false));

        vehicle.setFloor(null);
        vehicle.setParking(null);

        System.out.println("vehicle Exit, Unparked");

        paymentService.pay(vehicle.getInTime(), vehicle.getVehicleType());

        // call payment service, create and pass vehicle object by sending the in time when vehicleEntered

    }
}
