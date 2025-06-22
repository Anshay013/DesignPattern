package carRentalSystem.model;

import java.util.List;

public class User {

    private String userId;
    private String drivingLicense;

    private boolean isOwner;

    private List<RentCar> rentCars;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public List<RentCar> getRentCars() {
        return rentCars;
    }

    public void setRentCars(List<RentCar> rentCars) {
        this.rentCars = rentCars;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public void addRegisteredCar(RentCar car){
        rentCars.add(car);
    }

}
