package parkingLot.paymentservice.paymentmethod;

import parkingLot.paymentservice.PaymentStratergy;

public class PaymentUPI implements PaymentStratergy {
    @Override
    public void processPayment() {
        System.out.println("payment processed vaia UPI");
    }
}
