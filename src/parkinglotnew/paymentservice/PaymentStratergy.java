package parkinglotnew.paymentservice;

import parkinglotnew.VehicleType;

public interface PaymentStratergy {

    void processPayment(Long inTime,  VehicleType type);
}
