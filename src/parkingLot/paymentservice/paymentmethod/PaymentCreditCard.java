package parkingLot.paymentservice.paymentmethod;

import parkingLot.paymentservice.PaymentStratergy;

public class PaymentCreditCard implements PaymentStratergy {
    @Override
    public void processPayment() {
        System.out.println("payment processed via Credit Card");
    }
}
