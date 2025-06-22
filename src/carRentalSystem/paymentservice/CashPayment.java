package carRentalSystem.paymentservice;

import carRentalSystem.Constants;
import carRentalSystem.model.Trip;

public class CashPayment implements PaymentStrategy {
    @Override
    public void getPayment(float toPay) {

        float total_price = toPay ;

        System.out.println("Your total price via cash is " + (int) total_price);
    }
}
