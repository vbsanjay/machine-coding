package Entity;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int registrationNumber;
    private String vehicleType;
    List<Journey> journeys;

    public Vehicle(int registrationNumber, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.journeys = new ArrayList<>();
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }
}
