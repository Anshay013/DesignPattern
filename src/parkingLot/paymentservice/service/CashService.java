package parkingLot.paymentservice.service;

import parkingLot.paymentservice.PaymentService;
import parkingLot.paymentservice.PaymentStratergy;

public class CashService extends PaymentService {
    public CashService(PaymentStratergy paymentStratergy) {
        super(paymentStratergy);
    }
}
