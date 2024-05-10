package services;

import java.util.Scanner;

public class UserIOService {
    Scanner sc = new Scanner(System.in);
    private int numberOfTaxi;
    private int CustomerID;
    private int PickupPoint;
    private int DropPoint;
    private int pickupTime;
    public void getInputForInitialSetup(){
        PrintService.printGetNumberOfTaxi();
        numberOfTaxi = sc.nextInt();
    }

    public void getBookingDetailsFromUser(){
        PrintService.printGetCustomerID();
        CustomerID = sc.nextInt();
        PrintService.printGetPickupPoint();
        PickupPoint = sc.next().charAt(0) - 'A' + 1;
        PrintService.printGetDropPoint();
        DropPoint = sc.next().charAt(0) - 'A' + 1;
        PrintService.printGetPickupTime();
;       pickupTime = sc.nextInt();
    }

    public int getNumberOfTaxi() {
        return numberOfTaxi;
    }

    public void setNumberOfTaxi(int numberOfTaxi) {
        this.numberOfTaxi = numberOfTaxi;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getPickupPoint() {
        return PickupPoint;
    }

    public void setPickupPoint(int pickupPoint) {
        PickupPoint = pickupPoint;
    }

    public int getDropPoint() {
        return DropPoint;
    }

    public void setDropPoint(int dropPoint) {
        DropPoint = dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }
}
