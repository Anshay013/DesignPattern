package carRentalSystem.Tripservice;

import carRentalSystem.Constants;
import carRentalSystem.model.RentCar;
import carRentalSystem.model.Trip;
import carRentalSystem.paymentservice.PaymentService;

public class TripEndServiceImpl extends TripEndService{


    @Override
    public float calculateMoney(RentCar car) {
        Trip trip = car.getCurrentTrip();
        long extraTime = System.currentTimeMillis() - trip.getRentCar().getTimeDuration().getEndTime();


        int price =  trip.getRentCar().getPerHourPrice();
        float durationHours = trip.getDuration() / 1000 * 60 * 60;

        float total_price = price * (durationHours + extraTime);
        System.out.println("Money without tax is.. Now select your payment method");
        return total_price;

    }
}
