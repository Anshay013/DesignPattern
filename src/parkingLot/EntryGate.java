package parkingLot;

import parkingLot.manager.ParkingSpotManager;
import parkingLot.model.Vehicle;
import parkingLot.parkingStrategy.ParkingSpotStrategy;

public class EntryGate {

    private ParkingSpotManager spotManager;
    private Vehicle vehicle;
    public EntryGate(ParkingSpotManager spotManager){
        this.spotManager = spotManager;
    }

    void parkVehicle(){
        spotManager.parkVehicle();
    }

}
