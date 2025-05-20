package parkinglotnew.model;

import parkinglotnew.Floor;
import parkinglotnew.VehicleType;

public class Vehicle {

    private Parking parking;

    public Long getInTime() {
        return inTime;
    }

    public void setInTime(Long inTime) {
        this.inTime = inTime;
    }

    private Floor floor;
    private final String vehicleNo;
    private VehicleType vehicleType;
    private Long inTime;


    public Vehicle(Parking parking, Floor floor, VehicleType vehicleType, String vehicleNo){
        this.floor = floor;
        this.parking = parking;
        this.vehicleType = vehicleType;
        this.vehicleNo = vehicleNo;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
