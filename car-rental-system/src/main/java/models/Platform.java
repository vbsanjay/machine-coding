package models;

import java.util.List;

public class Platform {
    private int platformId;
    private List<Vehicle> vehicles;

    public Platform(int platformId, List<Vehicle> vehicles) {
        this.platformId = platformId;
        this.vehicles = vehicles;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
