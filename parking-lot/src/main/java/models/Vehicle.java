package models;

public class Vehicle {
    String registrationNumber;
    Floor floor;
    String vehicleType;
    ParkingSlot parkingSlot;
    String color;

    public Vehicle(String registrationNumber, String vehicleType, String color) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public Vehicle(String registrationNumber, Floor floor, String vehicleType, ParkingSlot parkingSlot, String color) {
        this.registrationNumber = registrationNumber;
        this.floor = floor;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
