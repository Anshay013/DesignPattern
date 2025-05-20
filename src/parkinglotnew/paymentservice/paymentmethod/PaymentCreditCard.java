package parkinglotnew.paymentservice.paymentmethod;

import parkinglotnew.VehicleType;
import parkinglotnew.paymentservice.PaymentStratergy;

public class PaymentCreditCard implements PaymentStratergy {
    @Override
    public void  processPayment(Long inTime,  VehicleType type) {
        Double basic = (double) ((System.currentTimeMillis() - inTime) / 1000);
        basic = basic / 60;
        // for 1 min we have Rs 5 and credit card gst is 20 %
        basic *= 5;

        Double total =  (basic + 0.2 * basic);
        System.out.println("payment processed via Credit Card of Rs " + total );
    }
}
