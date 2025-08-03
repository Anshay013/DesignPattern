package BookMyshow;

import BookMyshow.manager.*;
import BookMyshow.model.Seat;
import BookMyshow.model.User;
import parkingLot.paymentservice.PaymentStratergy;
import parkingLot.paymentservice.paymentmethod.PaymentUPI;

import java.util.List;

public class DriverCode {

    public static void main(String[] args) {

        User user = new User();
        user.setUserId("1234");
        // add more things.



        BookingManager manager = new BookingManagerImpl();

        // user clicks on a movie show get the movie and selects seats.
        // These seats are added via frontend and sent to us. Some exposed api.

        // we collect it here, do a loop and add it to seats.


        List<Seat> seats = null;
        // we get a booking id.
        String bookingId = manager.bookSeats(user, seats);

        // user clicks payment and select the method in UI and sends it to us.

        // backend checks the method type and sets the strategy e.g UPI was done.
        PaymentStratergy stratergy = new PaymentUPI();

        manager.injectService(new PaymentmanagerImpl(stratergy));

        String ScreenId = manager.doPayment(user, bookingId);

        // payment is successful and screenId is returned


        // frontend makes a ticket UI.

        // Show finished mark "seats" as unoccupied. mark bookingId as null from user. and handle other scenarios as well.






    }
}
