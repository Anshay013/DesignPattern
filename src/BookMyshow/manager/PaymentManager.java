package BookMyshow.manager;

import parkingLot.paymentservice.PaymentStratergy;

public abstract class PaymentManager implements ServiceManager {

    public PaymentManager(PaymentStratergy paymentStratergy){
        System.out.println("initialize payment manager");
    }

    public abstract void initPatyment(String userId, String bookingId);

}
