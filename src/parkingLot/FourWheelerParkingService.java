package parkingLot;

import parkingLot.paymentservice.PaymentService;

public class FourWheelerParkingService extends ParkingLotService {
    private EntryGate entryGate;
    private ExitGate exitGate;


    FourWheelerParkingService(EntryGate entryGate) {
        super(entryGate);
        this.entryGate = entryGate;
    }

    FourWheelerParkingService(ExitGate exitGate) {
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
