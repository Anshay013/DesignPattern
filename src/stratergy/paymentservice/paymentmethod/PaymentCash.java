package stratergy.paymentservice.paymentmethod;

import stratergy.paymentservice.PaymentStratergy;

public class PaymentCash implements PaymentStratergy {
    @Override
    public void processPayment() {
        System.out.println("payment processed via Cash");
    }
}
