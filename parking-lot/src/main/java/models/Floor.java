package models;

import java.util.List;

public class Floor {
    String id;
    int floorNumber;
    List<ParkingSlot> parkingSlots;

    public Floor(String id, int floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
