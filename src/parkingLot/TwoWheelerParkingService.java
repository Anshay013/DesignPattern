package parkingLot;

import parkingLot.model.Vehicle;

public class TwoWheelerParkingService extends ParkingLotService{

    private EntryGate entryGate;
    private ExitGate exitGate;

    public TwoWheelerParkingService(EntryGate entryGate) {
        super(entryGate);
        this.entryGate = entryGate;
    }

    public TwoWheelerParkingService(ExitGate exitGate) {
        super(exitGate);
        this.exitGate = exitGate;
    }

    @Override
    public void vehicleEntry() {
        super.vehicleEntry();
        System.out.println("Two Wheeler Entry");
        entryGate.parkVehicle();
    }

    @Override
    public void vehicleExit() {
        super.vehicleExit();
        System.out.println("Two Wheeler Exit");
        exitGate.removeVehicle();
    }

    @Override
    public void computeCost() {
        super.computeCost();
        System.out.println("Two Wheeler cost");
        exitGate.computeCost();
    }


}
