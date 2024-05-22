package Entity;

import java.util.ArrayList;
import java.util.List;

public class Journey {
    private int start;
    private int end;
    private int amountSpent;
    private Vehicle vehicle;
    private List<Bill> bills;

    public Journey(int start, int end, int amountSpent, Vehicle vehicle) {
        this.start = start;
        this.end = end;
        this.amountSpent = amountSpent;
        this.vehicle = vehicle;
        this.bills = new ArrayList<>();
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(int amountSpent) {
        this.amountSpent = amountSpent;
    }
}
