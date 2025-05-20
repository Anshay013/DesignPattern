package parkinglotnew.gate;

import parkinglotnew.paymentservice.PaymentService;
import parkinglotnew.model.Vehicle;

public abstract class ExitGateManager {

    ExitGateManager(){
        System.out.println("Init Exit Service");
    }

    public void vehilceExit(Vehicle vehicle){
        System.out.println("vehicle is leaving collect parking payment");
    }
}
