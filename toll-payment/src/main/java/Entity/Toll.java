package Entity;

import java.util.ArrayList;
import java.util.List;

public class Toll {
    private int tollNumber;
    private int totalEarning;
    private ChargingScheme chargingScheme;
    private List<Bill> bills;

    public Toll(int tollNumber, int totalEarning, ChargingScheme chargingScheme) {
        this.tollNumber =  tollNumber;
        this.totalEarning = totalEarning;
        this.chargingScheme = chargingScheme;
        this.bills = new ArrayList<>();
    }

    public int getTollNumber() {
        return tollNumber;
    }

    public void setTollNumber(int tollNumber) {
        this.tollNumber = tollNumber;
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(int totalEarning) {
        this.totalEarning = totalEarning;
    }

    public ChargingScheme getChargingScheme() {
        return chargingScheme;
    }

    public void setChargingScheme(ChargingScheme chargingScheme) {
        this.chargingScheme = chargingScheme;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
