package BookMyshow.manager;

import parkingLot.paymentservice.PaymentStratergy;

public class PaymentmanagerImpl extends PaymentManager {

    private PaymentStratergy paymentStratergy;

    public PaymentmanagerImpl(PaymentStratergy paymentStratergy) {
        super(paymentStratergy);
        this.paymentStratergy = paymentStratergy;
    }

    @Override
    public void initPatyment(String userId, String bookingId) {
         paymentStratergy.processPayment();
    }

}
