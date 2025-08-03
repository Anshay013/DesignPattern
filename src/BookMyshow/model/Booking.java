package BookMyshow.model;

import java.util.List;

public class Booking {

    private int BookingId;
    private int ScreenId;
    List<Seat> seats;
    private int PaymentStatus;

    public int getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public int getScreenId() {
        return ScreenId;
    }

    public void setScreenId(int screenId) {
        ScreenId = screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
