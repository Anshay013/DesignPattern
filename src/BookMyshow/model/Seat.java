package BookMyshow.model;

import BookMyshow.SeatType;

public class Seat {

    private String seatId;
    private String seatPrice;
    private SeatType type;
    private boolean lockStatus;
    private boolean Booked;

    public String getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(String seatPrice) {
        this.seatPrice = seatPrice;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public boolean isLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public boolean isBooked() {
        return Booked;
    }

    public void setBooked(boolean booked) {
        Booked = booked;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}
