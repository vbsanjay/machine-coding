package Service;

import Entity.Vehicle;

import java.util.List;
import java.util.Scanner;

public class UserInputOutputService {
    static Scanner sc = new Scanner(System.in);
    public static int fetchUserChoiceFromUser(){
        System.out.println();
        System.out.println("1. Pass a vehicle from one point to another and display the total amount to be paid in the toll");
        System.out.println("2. Display details of all toll");
        System.out.println("3. Display the details of all the vehicles");
        System.out.println("4. Exit");
        return sc.nextInt();
    }

    public static int fetchStartPointFromUser(){
        System.out.print("Mention the start Point: ");
        return sc.nextInt();
    }
    public static int fetchEndPointFromUser(){
        System.out.print("Mention the end Point: ");
        return sc.nextInt();
    }

    public static Vehicle fetchTheVehicleToUseFromUser(List<Vehicle> vehicles){
        System.out.println("Pick a vehicle to use from below list");
        System.out.printf("%5s %20s %20s%n", "Sl.no", "registrationNumber", "vehicleType");
        System.out.println("--------------------------------------------------");
        for(int i = 0; i < vehicles.size(); i++){
            int registrationNumber = vehicles.get(i).getRegistrationNumber();
            String vehicleType = vehicles.get(i).getVehicleType();
            int slNo = i+ 1;
            System.out.printf("%5d %20d %20s%n", slNo, registrationNumber, vehicleType);
        }
        int slNoChoice = sc.nextInt();
        System.out.println("You have Chosen " + vehicles.get(slNoChoice - 1).getVehicleType() +  " with registrationNumber " + vehicles.get(slNoChoice - 1).getRegistrationNumber());
        return vehicles.get(slNoChoice - 1);
    }


}
