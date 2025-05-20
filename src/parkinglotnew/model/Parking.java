package parkinglotnew.model;

public class Parking {

    private int parkingNo;
    private int floorAssociated;
    private String ticketId;
    private Boolean occupied;
    private Vehicle vehicle;

    public Parking(int parkingNo, int floorAssociated, String ticketId, Boolean occupied){
        this.floorAssociated = floorAssociated;
        this.ticketId = ticketId;
        this.parkingNo = parkingNo;
        this.occupied = occupied;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(int parkingNo) {
        this.parkingNo = parkingNo;
    }

    public int getFloorAssociated() {
        return floorAssociated;
    }

    public void setFloorAssociated(int floorAssociated) {
        this.floorAssociated = floorAssociated;
    }


    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
