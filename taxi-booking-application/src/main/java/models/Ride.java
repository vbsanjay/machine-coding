package models;

public class Ride {
    private int startPoint;
    private int endPoint;
    private TimeSlot timeSlot;
    private int Amount;

    public Ride(int startPoint, int endPoint, TimeSlot timeSlot, int amount) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.timeSlot = timeSlot;
        Amount = amount;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
