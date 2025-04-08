package parkingLot.paymentservice.service;

import parkingLot.paymentservice.PaymentService;
import parkingLot.paymentservice.PaymentStratergy;

public class UPIService extends PaymentService {
    public UPIService(PaymentStratergy paymentStratergy) {
        super(paymentStratergy);
    }
}
