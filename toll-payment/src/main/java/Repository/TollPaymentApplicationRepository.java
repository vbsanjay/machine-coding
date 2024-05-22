package Repository;

import Entity.ChargingScheme;
import Entity.Toll;
import Entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class TollPaymentApplicationRepository {
    static List<Toll> tolls = new ArrayList<>();
    static List<Vehicle> vehicles = new ArrayList<>();
    static int totalNumberOfTolls;
    static int totalNumberOfVehicle;
    public static void initializeTollPaymentApplication(int numberOfTolls, int numberOfVehicle){
        createTolls(numberOfTolls);
        createVehicle(numberOfVehicle);
        totalNumberOfTolls = numberOfTolls;
        totalNumberOfVehicle = numberOfVehicle;
    }
    public static void createTolls(int numberOfTolls){
        for(int i = 1; i <= numberOfTolls; i++){
            ChargingScheme chargingScheme = createChargingScheme();
            Toll toll = new Toll(i, 0, chargingScheme);
            tolls.add(toll);
        }
    }

    public static ChargingScheme createChargingScheme(){
        // Schemes are generated randomly
        int randomNumber = (int) Math.floor(Math.random() * 4) + 1;
        ChargingScheme chargingScheme;
        switch (randomNumber){
            case 1:
                chargingScheme = new ChargingScheme(20,40,60,80);
                break;
            case 2:
                chargingScheme = new ChargingScheme(25,50,100,120);
                break;
            case 3:
                chargingScheme = new ChargingScheme(15,40,60,80);
                break;
            default:
                chargingScheme = new ChargingScheme(0,10,20,30);
                break;
        }
        return chargingScheme;
    }

    public static void createVehicle(int numberOfVehicle){
        int registrationNumber = 1001;
        for(int i = 0; i < numberOfVehicle; i++){

            int randomNumber = (int) Math.floor(Math.random() * 4) + 1;
            Vehicle vehicle;

            if(randomNumber == 1)
                vehicle = new Vehicle(registrationNumber, "BIKE");
            else if(randomNumber == 2)
                vehicle = new Vehicle(registrationNumber, "CAR");
            else if(randomNumber == 3)
                vehicle = new Vehicle(registrationNumber, "TRUCK");
            else
                vehicle = new Vehicle(registrationNumber, "OVER_SIZED");

            registrationNumber++;

            vehicles.add(vehicle);
        }
    }

    public static List<Toll> getTolls() {
        return tolls;
    }

    public static void setTolls(List<Toll> tolls) {
        TollPaymentApplicationRepository.tolls = tolls;
    }

    public static List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static void setVehicles(List<Vehicle> vehicles) {
        TollPaymentApplicationRepository.vehicles = vehicles;
    }

    public static int getTotalNumberOfTolls() {
        return totalNumberOfTolls;
    }

    public static void setTotalNumberOfTolls(int totalNumberOfTolls) {
        TollPaymentApplicationRepository.totalNumberOfTolls = totalNumberOfTolls;
    }

    public static int getTotalNumberOfVehicle() {
        return totalNumberOfVehicle;
    }

    public static void setTotalNumberOfVehicle(int totalNumberOfVehicle) {
        TollPaymentApplicationRepository.totalNumberOfVehicle = totalNumberOfVehicle;
    }
}
