package BookMyshow.model;

import BookMyshow.ScreenType;
import BookMyshow.Status;

import java.util.List;

public class Screen {

    private String ScreenId;
    List<Seat>seatList;
    private Status status;
    private String currentMovieName;

    public String getScreenId() {
        return ScreenId;
    }

    public void setScreenId(String screenId) {
        ScreenId = screenId;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    private List<Schedule> scheduleList;

    public ScreenType getType() {
        return type;
    }

    public void setType(ScreenType type) {
        this.type = type;
    }

    private ScreenType type;


    public String getId() {
        return ScreenId;
    }

    public void setId(String id) {
        ScreenId = id;
    }

    public String getCurrentMovieName() {
        return currentMovieName;
    }

    public void setCurrentMovieName(String currentMovieName) {
        this.currentMovieName = currentMovieName;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
