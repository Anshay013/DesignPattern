package parkingLot.parkingStrategy;


import parkingLot.model.ParkingSpot;
import parkingLot.model.Vehicle;

public interface ParkingSpotStrategy {

    boolean parkVehicle(Vehicle vehicle);

    boolean removeVehicle(Vehicle vehicle);

    boolean removeParkingSpace();

    boolean addParkingSpace(int VehicleType, int space);

    void computeCost(ParkingSpot parkingSpot);

}
