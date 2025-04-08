package parkingLot.model;



public class ParkingSpot {
    private int id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private int EntryTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(int entryTime) {
        EntryTime = entryTime;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
