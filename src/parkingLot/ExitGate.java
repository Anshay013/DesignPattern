package parkingLot;

import parkingLot.manager.ParkingSpotManager;
import parkingLot.model.Vehicle;
import parkingLot.parkingStrategy.ParkingSpotStrategy;

public class ExitGate {

    private ParkingSpotManager spotManager;
    private Vehicle vehicle;
    public ExitGate(ParkingSpotManager spotManager){
        this.spotManager = spotManager;
    }
    // 2
    public void removeVehicle(){
        spotManager.removeVehicle();
    }
    // 1
    public void computeCost(){
        spotManager.computeCost();
    }
}
