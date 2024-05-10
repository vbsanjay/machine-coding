package models;

public class Ride {
    private static int idProvider = 1;
    private int id;
    private int customerID;
    private int startPoint;
    private int endPoint;
    private TimeSlot timeSlot;
    private int Amount;

    public Ride(int customerID, int startPoint, int endPoint, TimeSlot timeSlot, int amount) {
        this.id = idProvider++;
        this.customerID = customerID;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.timeSlot = timeSlot;
        Amount = amount;
    }

    public int getId() {
        return id;
    }

    public static int getIdProvider() {
        return idProvider;
    }

    public static void setIdProvider(int idProvider) {
        Ride.idProvider = idProvider;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setId(int id) {
        this.id = id;
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
