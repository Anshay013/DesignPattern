package parkinglotnew;

import parkinglotnew.model.Parking;

public interface ParkingLotService {

    void setFloors(int floors);
    int getFloors();

    void addParking(Floor floor, Parking Parking);

    void removeParking(Floor floor, Parking Parking);
}
