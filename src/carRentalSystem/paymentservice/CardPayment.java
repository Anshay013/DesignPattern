package carRentalSystem.paymentservice;

import carRentalSystem.Constants;
import carRentalSystem.model.Trip;

public class CardPayment implements PaymentStrategy{
    @Override
    public void getPayment(float toPay) {

        float total_price = toPay*  Constants.CARD_TAX;

        System.out.println("Your total price through Card is " +  total_price);
    }
}
