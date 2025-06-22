package carRentalSystem.model;

public class Trip {

    private String TripId;
    private long duration;
    private boolean hasStarted;
    private String hasEnded;
    private RentCar rentCar;

    public String getTripId() {
        return TripId;
    }

    public void setTripId(String tripId) {
        TripId = tripId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public boolean getHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public String getHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(String hasEnded) {
        this.hasEnded = hasEnded;
    }

    public RentCar getRentCar() {
        return rentCar;
    }

    public void setRentCar(RentCar rentCar) {
        this.rentCar = rentCar;
    }
}
