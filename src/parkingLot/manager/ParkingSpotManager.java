package parkingLot.manager;

import parkingLot.model.ParkingSpot;
import parkingLot.model.Vehicle;
import parkingLot.parkingStrategy.ParkingSpotStrategy;

public abstract class ParkingSpotManager {


    ParkingSpotManager(Vehicle vehicle, ParkingSpotStrategy strategy){
    }
   // called on entry
   public void parkVehicle() {
        System.out.println("Add parking space");
    }
    // called onn exit
    public void removeVehicle() {
        System.out.println("remove Vehicle");
    }
    void removeParkingSpace(){
        System.out.println("remove parking space");
    }

    void addParkingSpace(int VehicleType, int space){
        System.out.println("Add parking space");
    }

    // after payment is done then, removed Vehicle is called from ExitGate interface
    public void computeCost(){
        System.out.println("The cost is :");
    }



}
