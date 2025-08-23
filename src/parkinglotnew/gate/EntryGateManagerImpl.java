package parkinglotnew.gate;

import parkinglotnew.Floor;
import parkinglotnew.model.Parking;
import parkinglotnew.model.Vehicle;

import java.util.List;

public class EntryGateManagerImpl extends EntryGatemanager {

    private List<Floor>floors;

    public EntryGateManagerImpl( List<Floor>floors){
          super();
          this.floors = floors;
    }

    @Override
    public void addvehicle(Vehicle vehicle){
        super.addvehicle(vehicle);

        for(int i = 0; i < floors.size(); ++ i){
            Floor floor = floors.get(i);

              List<Parking>list = floor.getParkingLotList(vehicle.getVehicleType());

              for(Parking parking: list){
                  if(!parking.getOccupied()){
                      String ticketId =  "PMF " + String.valueOf(parking.getParkingNo()) + vehicle.getVehicleNo();
                      vehicle.setInTime(System.currentTimeMillis());
                      vehicle.setFloor(floor);
                      Parking newPaking = new Parking(parking.getParkingNo(), parking.getFloorAssociated(), ticketId, true);
                      floor.getParkingLotList(vehicle.getVehicleType())
                              .set(parking.getParkingNo(), newPaking);

                      vehicle.setParking(newPaking);
                      System.out.println("Parking alloted");
                      break;
                  }

            }

        }
        if(vehicle.getFloor() == null){
            System.out.println("No space available wait for other vehicle to exit");
        }

    }
}
