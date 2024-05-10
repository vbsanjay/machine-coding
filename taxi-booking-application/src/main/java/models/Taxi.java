package models;

import java.util.List;


//id, state(at what point the taxi is, is it available or not) , earning
public class Taxi {
    private int id;
    private List<TimeSlot> occupiedTimeSlots;
    private int totalEarning;
    private List<Ride> rides;

    public Taxi(int id, List<TimeSlot> occupiedTimeSlots, int totalEarning, List<Ride> rides) {
        this.id = id;
        this.occupiedTimeSlots = occupiedTimeSlots;
        this.totalEarning = totalEarning;
        this.rides = rides;
    }

    public boolean isAvailable(int pickupTime) {
        for (TimeSlot slot : occupiedTimeSlots) {
            // Check if the pickup time falls within an occupied time slot
            if (pickupTime >= slot.getStart() && pickupTime < slot.getEnd()) {
                return false; // Taxi is not available
            }
        }
        return true; // Taxi is available
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TimeSlot> getOccupiedTimeSlots() {
        return occupiedTimeSlots;
    }

    public void setOccupiedTimeSlots(List<TimeSlot> occupiedTimeSlots) {
        this.occupiedTimeSlots = occupiedTimeSlots;
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(int totalEarning) {
        this.totalEarning = totalEarning;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}



