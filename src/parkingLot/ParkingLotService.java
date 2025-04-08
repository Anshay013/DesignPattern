package parkingLot;

import parkingLot.model.Vehicle;

public abstract class ParkingLotService {


    ParkingLotService(EntryGate entryGate){}
    ParkingLotService(ExitGate exitGate){}

    public void vehicleEntry(){
        System.out.print("Vehicle Entering");
    }

    public void vehicleExit(){
        System.out.println("Vehicle Exit");
    }

    public void computeCost(){
        System.out.println("Calculate cost");
    }
}
