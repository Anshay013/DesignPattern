package carRentalSystem.model;

public class TimeDuration {


    private long startTime;
    private long endTime;

    public TimeDuration(long startTime, long endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }


}
