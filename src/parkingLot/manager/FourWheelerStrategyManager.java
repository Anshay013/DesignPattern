package parkingLot.manager;

import parkingLot.model.ParkingSpot;
import parkingLot.model.Vehicle;
import parkingLot.parkingStrategy.ParkingSpotStrategy;

public class FourWheelerStrategyManager extends ParkingSpotManager {

    private ParkingSpotStrategy strategy;
    private Vehicle vehicle;

    FourWheelerStrategyManager(Vehicle vehicle, ParkingSpotStrategy strategy) {
        super(vehicle, strategy);
        this.strategy = strategy;
        this.vehicle = vehicle;
    }

    @Override
    public void parkVehicle(){
        super.removeParkingSpace();
        strategy.parkVehicle(vehicle);
    }

    @Override
    public void removeVehicle() {
        super.removeVehicle();
        strategy.removeVehicle(vehicle);
    }

    @Override
    void removeParkingSpace() {
        super.removeParkingSpace();
        strategy.removeParkingSpace();
    }

    @Override
    void addParkingSpace(int VehicleType, int space) {
        super.addParkingSpace(VehicleType, space);
        strategy.addParkingSpace(VehicleType, space);
    }

    @Override
    public void computeCost() {
        super.computeCost();
        strategy.computeCost(vehicle.getSpot());
    }
}
