package carRentalSystem;

import carRentalSystem.model.RentCar;
import carRentalSystem.model.TimeDuration;
import carRentalSystem.model.Trip;
import carRentalSystem.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class CarRentalImpl extends CarRentalService{

    private VehicleInventory inventory;

    public CarRentalImpl(VehicleInventory intventory) {
        super(intventory);
        this.inventory = intventory;
    }

    @Override
    public User registerUser(String drivingLicense, boolean isOwner) {
        /// save this user to DB
        User user = new User();
        user.setDrivingLicense(drivingLicense);
        Random random = new Random();
        // nextInt(100) generates a number between 0 (inclusive) and 100 (exclusive)
        // Adding 1 shifts the range to 1 (inclusive) and 100 (inclusive)
        int randomNumber = random.nextInt(100) + 1;
        String userID = drivingLicense + LocalDate.now() + (randomNumber);
        user.setUserId(userID);

        user.setOwner(isOwner);
        user.setRentCars(new ArrayList<>());

        return user;

    }

    @Override
    public RentCar registerCar(User user, RentCar car) {
        // save to db

        user.addRegisteredCar(car);
        return car;
    }

    @Override
    public RentCar SelectedCar(User user, RentCar car, long from, long to) {
        // Fetched a List from inventory --> any inventory serer

          TimeDuration t = new TimeDuration(from, to);
          car.setTimeDuration(t);
          car.setCurrentUser(user);

          return car;

    }

    @Override
    public List<RentCar> fetchCarList(String location, CarType carType){
        return getCarForLocation(location, carType);
    }

    private List<RentCar> getCarForLocation(String location, CarType carType){
        List<RentCar>carList = null;
        try {
            List<RentCar> list = inventory.getCarList();
            carList = list.stream()
                    .filter(x -> x.getLocation().equals(location) && x.isAvailable() && x.getCarType().equals(carType))
                    .toList();
        }
        catch (Exception e){
            Logger.getLogger(e.getMessage());
            System.out.println("unable to fetch list from Inventory server");
        }
        return carList;
    }

    @Override
    public Trip rent(RentCar car, User user) {
        Trip trip = new Trip();
        long start = car.getTimeDuration().getStartTime();
        long end = car.getTimeDuration().getEndTime();

        long duration = end - start;

        trip.setDuration(duration);
        String tripId = car.getNumberPlate() + LocalDate.now();
        trip.setRentCar(car);
        car.setIsAvailable(false);

        trip.setTripId(tripId);
        return trip;
    }
}
