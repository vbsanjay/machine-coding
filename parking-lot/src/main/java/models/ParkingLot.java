package models;

import java.util.List;

public class ParkingLot {
    String id;
    List<Floor> floors;

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
}
