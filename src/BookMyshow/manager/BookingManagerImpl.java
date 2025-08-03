package BookMyshow.manager;

import BookMyshow.model.Seat;
import BookMyshow.model.User;

import java.util.List;

public class BookingManagerImpl implements BookingManager {

    private PaymentManager paymentManager;

    @Override
    public void injectService(ServiceManager serviceManager) {
        if (serviceManager instanceof PaymentManager) {
            this.paymentManager = (PaymentManager) serviceManager;
        } else {
            throw new IllegalArgumentException("Expected PaymentManager");
        }
    }


    @Override
    public String bookSeats(User user, List<Seat> seats) {
        // logic to boo seat
        // lock the seats and add it to use
        return "";
    }

    @Override
    public String doPayment(User user, String bookingId) {
        paymentManager.initPatyment(user.getUserId(), bookingId);
        return "";
    }


}
