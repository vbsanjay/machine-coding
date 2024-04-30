import models.Floor;
import models.ParkingLot;
import models.ParkingSlot;
import services.ParkingLotService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot System");
        System.out.println("Create a Parking Lot");
        System.out.println("Syntax: create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        ParkingLot parkingLot = ParkingLotService.createParkingLot(command);
        System.out.println("Parking Lot has been created");
        List<Floor> floors = parkingLot.getFloors();
        System.out.println("Printing details of each floor");
        for (int i = 0; i < floors.size(); i++){
            System.out.println("Printing details of "+ (i+1) + "th floor");
            Floor floor = floors.get(i);
            System.out.println("floor id: " + floor.getId());
            System.out.println("floor number: " + floor.getFloorNumber());
            List<ParkingSlot> slots = floor.getParkingSlots();
            for (int j = 0; j < slots.size(); j++) {
                ParkingSlot slot = slots.get(j);
                System.out.println("slot id: " + slot.getId());
                System.out.println("slot floor number: " + slot.getFloor().getFloorNumber());
                System.out.println("slot vehicle type: " + slot.getVehicleType());
            }
        }
        System.out.println("parking lot floor "+parkingLot.getFloors());
        System.out.println("parking lot id" + parkingLot.getId());
    }
}