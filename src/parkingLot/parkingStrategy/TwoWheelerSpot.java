package parkingLot.parkingStrategy;

import parkingLot.model.ParkingSpot;
import parkingLot.model.Vehicle;
import parkingLot.paymentservice.PaymentService;
import parkingLot.paymentservice.paymentmethod.PaymentUPI;
import parkingLot.paymentservice.service.UPIService;

// class with actual implementation
public class TwoWheelerSpot implements ParkingSpotStrategy {

    @Override
    public boolean parkVehicle(Vehicle v) {

        ParkingSpot spot = new ParkingSpot();
        spot.setId(0);
        v.setSpot(spot);
        // park only if the health check for parking space is good
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        // remove the vehicle from DB
        int id = vehicle.getSpot().getId();
        // remove id.
        return true;
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
        PaymentService paymentService = new UPIService(new PaymentUPI());
        // calculate;
        paymentService.pay();
        // done, then exit the vehicle and remove it from Vehicle database and parkingLost database i.r make it empty for that Vehicle
        System.out.println(50);
    }


}
