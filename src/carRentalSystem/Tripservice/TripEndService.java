package carRentalSystem.Tripservice;

import carRentalSystem.model.RentCar;
import carRentalSystem.paymentservice.PaymentService;

public abstract class TripEndService {

    public abstract float calculateMoney(RentCar car);
}
