package parkinglotnew.paymentservice;

import parkinglotnew.VehicleType;
import parkinglotnew.model.Vehicle;

public class PaymentService {

    private final PaymentStratergy paymentStratergy;

    public PaymentService(PaymentStratergy paymentStratergy) {
        this.paymentStratergy = paymentStratergy;
    }

 // if we want to use the same PaymentService object again and again then setPaymentStratergy can be beneficial
/*    public void setPaymentStratergy(PaymentStratergy paymentStratergy){
        this.paymentStratergy = paymentStratergy;
    }*/

    public void pay(long inTime, VehicleType type){
        paymentStratergy.processPayment(inTime, type);
    }
}
