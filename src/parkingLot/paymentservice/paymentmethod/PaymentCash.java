package parkingLot.paymentservice.paymentmethod;

import parkingLot.paymentservice.PaymentStratergy;

public class PaymentCash implements PaymentStratergy {
    @Override
    public void processPayment() {
        System.out.println("payment processed via Cash");
    }
}
