package models;

public class Ticket {
    private static int idGenerator = 1;
    int id;
    ParkingLot parkingLot;
    Floor floor;
    ParkingSlot parkingSlot;
    Vehicle vehicle;

    public Ticket(ParkingLot parkingLot, Floor floor, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.id = idGenerator++;
        this.parkingLot = parkingLot;
        this.floor = floor;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Ticket.idGenerator = idGenerator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
