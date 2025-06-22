package carRentalSystem.paymentservice;

import carRentalSystem.Constants;
import carRentalSystem.model.Trip;

public class UPIPayment implements PaymentStrategy{


    @Override
    public void getPayment(float toPay) {

        float total_price = toPay *  Constants.UPI_TAX;

       System.out.println("Your total price through UPI is " + (int) total_price);



    }
}
