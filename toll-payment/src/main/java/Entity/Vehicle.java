package Entity;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int registrationNumber;
    private String vehicleType;
    private List<Journey> journeys;
    private boolean vip;

    public Vehicle(int registrationNumber, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.journeys = new ArrayList<>();
        if(registrationNumber % 5 == 0) this.vip = true;
        else this.vip = false;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
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
