package parkinglotnew;

import parkinglotnew.model.Parking;

public class ParkingLotServiceImpl implements ParkingLotService {

    private int floors;

    @Override
    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public int getFloors() {
         return floors;
    }

    @Override
    public void addParking(Floor floor, Parking parking) {
        floor.addParking(parking);
    }

    @Override
    public void removeParking(Floor floor, Parking parking) {
        floor.unPark(parking);
    }
}
