import models.ParkingLot;
import services.DisplayService;
import services.ParkingLotService;
import services.ParkingService;
import services.UnparkService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot System");
        System.out.println("----------------------------------------------------------------");

        System.out.println("Create a Parking Lot using below syntax to proceed");
        System.out.println("Syntax: create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        ParkingLot parkingLot = null;
        try{
            parkingLot = ParkingLotService.createParkingLot(command);
            System.out.println("Parking Lot has been created");

        } catch (Exception e){
            System.out.println("Invalid Input. Please check your command.");
            sc.close();
            System.exit(0);
        }

        boolean loop = true;

        while(loop){
            System.out.println("Please enter your command.");
            System.out.println("Syntax: \n park_vehicle <vehicle_type> <reg_no> <color> \n unpark_vehicle <ticket_id> \n display <display_type> <vehicle_type> \n display_type: free_count, free_slots, occupied_slots");
            command = sc.nextLine();
            String[] commandSplit = command.split(" ");
            String task = commandSplit[0];
            switch (task) {
                case "park_vehicle": {
                    ParkingService.parkVehicle(commandSplit[1], commandSplit[2], commandSplit[3], parkingLot);
                    break;
                }
                case "unpark_vehicle":{
                    UnparkService.unparkVehicle(Integer.valueOf(commandSplit[1]));
                    break;
                }
                case "display":{
                    DisplayService.displayData(commandSplit[1], commandSplit[2], parkingLot);
                    break;
                }
                default:{
                    System.out.println("Invalid input. Please enter correct command");
                    break;
                }
            }


        }

    }
}