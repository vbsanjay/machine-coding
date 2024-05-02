package models;

public class Vehicle {
    private String registerNumber;
    private VehicleType vehicleType;
    private VehicleLog vehicleLog;

    public Vehicle(String registerNumber, VehicleType vehicleType) {
        this.registerNumber = registerNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
