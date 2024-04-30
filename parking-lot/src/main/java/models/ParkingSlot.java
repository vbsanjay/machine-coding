package models;

public class ParkingSlot {
    int id;
    Floor floor;
    String vehicleType;
    boolean isFree = true;

    public ParkingSlot(int id, Floor floor, String vehicleType) {
        this.id = id;
        this.floor = floor;
        this.vehicleType = vehicleType;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
