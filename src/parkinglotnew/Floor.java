package parkinglotnew;

import parkinglotnew.model.Parking;

import java.util.ArrayList;
import java.util.List;

public class Floor{

    private final int floorNo;
    private int parkingLots;
    private final ArrayList<Parking> parkingLotListCar = new ArrayList<>();
    private final ArrayList<Parking> parkingLotListBike= new ArrayList<>();
    private final ArrayList<Parking> parkingLotListTruck = new ArrayList<>();

    public Floor(int parkingLots, int floorNo){
        this.parkingLots = parkingLots;
        this.floorNo = floorNo;

        initParkingLotList(parkingLots);
    }

    public int getFloorNo() {
        return floorNo;
    }

    private void initParkingLotList(int parkingLot){
        int bikeLot = parkingLot / 2;
        int carLot = parkingLot / 3;
        int truckLot = parkingLot / 6;

        int i = 0;
        for(; i <= bikeLot; ++ i){
            parkingLotListBike.set(i, new Parking(i, floorNo, null, false));
        }

        for(; i <= carLot; ++ i){
            parkingLotListCar.set(i, new Parking(i, floorNo, null, false));
        }


        for(; i <= truckLot; ++ i){
            parkingLotListTruck.set(i, new Parking(i, floorNo, null, false));
        }
    }

    public int getParkingLots() {
        parkingLots = parkingLotListBike.size() + parkingLotListCar.size() + parkingLotListTruck.size();
        return parkingLots;
    }

    public void addParking(Parking parking) {
           getParkingLotList(parking.getVehicle().getVehicleType()).add(parking);
    }

    public void unPark(Parking parking){
        getParkingLotList(parking.getVehicle().getVehicleType()).remove(parking);
    }

    public List<Parking> getParkingLotList(VehicleType type) {

        return switch (type) {
            case BIKE -> parkingLotListBike;
            case CAR -> parkingLotListCar;
            case TRUCK -> parkingLotListTruck;
            default -> {
                System.out.println("Invalid vehicleType sent");
                yield null;
            }
        };
    }

}
