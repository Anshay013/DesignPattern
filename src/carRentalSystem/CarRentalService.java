package carRentalSystem;

import carRentalSystem.model.RentCar;
import carRentalSystem.model.Trip;
import carRentalSystem.model.User;

import java.util.List;

public abstract class CarRentalService {

    public CarRentalService(VehicleInventory intventory){
        System.out.println("init carRental Service");
    }

    abstract public User registerUser(String drivingLicense, boolean isOwner);

    abstract public RentCar registerCar(User user, RentCar car);

    abstract public List<RentCar> fetchCarList(String Location, CarType carType);

    abstract public RentCar SelectedCar(User user, RentCar car, long from, long to);

   abstract  public Trip rent(RentCar car, User user);
}
