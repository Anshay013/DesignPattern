package stratergy.paymentservice.service;

import stratergy.paymentservice.PaymentService;
import stratergy.paymentservice.PaymentStratergy;

public class CashService extends PaymentService {
    public CashService(PaymentStratergy paymentStratergy) {
        super(paymentStratergy);
    }
}
