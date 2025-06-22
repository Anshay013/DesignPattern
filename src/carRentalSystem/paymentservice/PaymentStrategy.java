package carRentalSystem.paymentservice;

import carRentalSystem.model.Trip;

public interface PaymentStrategy {

    void getPayment(float toPay);
}
