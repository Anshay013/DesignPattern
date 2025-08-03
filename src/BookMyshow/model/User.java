package BookMyshow.model;

import java.util.List;

public class User {

    private String userId;
    private int emailId;
    private long phone;
    private List<String> bookingIds;
    private List<String> screenIds;

    public List<String> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<String> bookingIds) {
        this.bookingIds = bookingIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public List<String> getScreenIds() {
        return bookingIds;
    }

    public void setScreenIds(List<String> bookingIds) {
        bookingIds = bookingIds;
    }
}
