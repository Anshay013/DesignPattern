package parkingLot.paymentservice.service;

import parkingLot.paymentservice.PaymentService;
import parkingLot.paymentservice.PaymentStratergy;

public class CredirCardService extends PaymentService {
    public CredirCardService(PaymentStratergy paymentStratergy) {
        super(paymentStratergy);
    }
}
