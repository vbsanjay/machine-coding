package models;

import java.util.List;

public class ParkingLot {
    String id;
    List<Floor> floors;
    int noOfFloors;
    int noOfSlotsPerFloor;

    public ParkingLot(String id, List<Floor> floors, int noOfFloors, int noOfSlotsPerFloor) {
        this.id = id;
        this.floors = floors;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public ParkingLot(String id, List<Floor> floor) {
        this.id = id;
        this.floors = floor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }
}

