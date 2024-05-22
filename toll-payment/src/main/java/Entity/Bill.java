package Entity;

public class Bill {
    private Vehicle vehicle;
    private Toll toll;
    private int billAmount;

    public Bill(Vehicle vehicle, Toll toll, int billAmount) {
        this.vehicle = vehicle;
        this.toll = toll;
        this.billAmount = billAmount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Toll getToll() {
        return toll;
    }

    public void setToll(Toll toll) {
        this.toll = toll;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
}
