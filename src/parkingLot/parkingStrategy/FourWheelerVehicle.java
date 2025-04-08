package parkingLot.parkingStrategy;

import parkingLot.model.ParkingSpot;
import parkingLot.model.Vehicle;
import parkingLot.paymentservice.PaymentService;
import parkingLot.paymentservice.paymentmethod.PaymentCreditCard;
import parkingLot.paymentservice.service.UPIService;

// class with actual implementation
public class FourWheelerVehicle implements ParkingSpotStrategy {
    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        // remove the vehicle from DB
        int id = vehicle.getSpot().getId();
        // remove id.
        return false;
    }

    @Override
    public boolean removeParkingSpace() {
        return false;
    }

    @Override
    public boolean addParkingSpace(int VehicleType, int space) {
        return false;
    }

    @Override
    public void computeCost(ParkingSpot parkingSpot) {
        // call paymentStrtergy as the customer chooses, with the ParkingLot assigned.
        PaymentService paymentService = new UPIService(new PaymentCreditCard());
        // calculate;
        paymentService.pay();
        // done, then exit the vehicle and remove it from Vehicle database and parkingLost database i.r make it empty for that Vehicle
        System.out.println(100);
    }
}
