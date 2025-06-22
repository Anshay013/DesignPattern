package carRentalSystem.model;

import carRentalSystem.CarType;
import org.jetbrains.annotations.NotNull;

public class RentCar {

    @NotNull
    private String numberPlate;
    @NotNull
    private CarType carType;
    private String location;
    private User currentOwner;
    private boolean isAvailable;
    private TimeDuration timeDuration;
    private User currentUser;
    private Trip currentTrip;
    private int perHourPrice;



    private RentCar(BuildCar buildCar) {
        this.numberPlate = buildCar.numberPlate;
        this.carType = buildCar.carType;
        this.location = buildCar.location;
        this.currentOwner = buildCar.currentOwner;
        this.isAvailable = buildCar.isAvailable;
        this.perHourPrice = buildCar.perHourPrice;

    }

    public int getPerHourPrice() {
        return perHourPrice;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public @NotNull String getNumberPlate() {
        return numberPlate;
    }

    public @NotNull CarType getCarType() {
        return carType;
    }

    public String getLocation() {
        return location;
    }

    public User getUser() {
        return currentOwner;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public TimeDuration getTimeDuration() {
        return timeDuration;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public void setTimeDuration(TimeDuration timeDuration) {
        this.timeDuration = timeDuration;
    }

    public static class BuildCar{

        private String numberPlate;
        private CarType carType;
        private String location;
        private User currentOwner;
        private boolean isAvailable;
        private User currentUser;
        private Trip currentTrip;
        private int perHourPrice;

        public BuildCar setNumberPlate(String numberPlate) {
            this.numberPlate = numberPlate;
            return this;
        }

        public BuildCar setCarType(CarType carType){
            this.carType = carType;
            return this;
        }

        public BuildCar setLocation(String location) {
            this.location = location;
            return this;
        }

        public BuildCar setUser(User currentOwner){
            this.currentOwner = currentOwner;
            return this;
        }

        public BuildCar setIsAvailable(boolean isAvailable){
            this.isAvailable = isAvailable;
            return this;
        }

        public BuildCar setPerHourPrice(int perHourPrice){
            this.perHourPrice = perHourPrice;
            return this;
        }

        public RentCar build(){
            return new RentCar(this);
        }
    }
}
