package carRentalSystem.paymentservice;

import carRentalSystem.model.Trip;

public  class PaymentService {

      private PaymentStrategy paymentStrategy;

      public PaymentService(PaymentStrategy paymentStrategy){
          System.out.println("init payment service");
          this.paymentStrategy = paymentStrategy;
      }

       public void doPayment(float toPay){
          paymentStrategy.getPayment(toPay);
       }
}
