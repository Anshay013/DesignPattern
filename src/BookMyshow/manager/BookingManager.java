package BookMyshow.manager;

import BookMyshow.model.Seat;
import BookMyshow.model.User;

import java.util.List;

public interface BookingManager extends ServiceManager {

    void injectService(ServiceManager serviceManager);

    public abstract String bookSeats(User user, List<Seat> seats);  // returns a booking ID

    public abstract String doPayment(User user, String bookingId); // retuns a seatID
}