package services;

import models.Floor;
import models.ParkingLot;
import models.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    public static ParkingLot createParkingLot(String command){
        //create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
        String[] commandSplit = command.split(" ");
        String parkingLotId = commandSplit[1];
        int noOfFloors = Integer.valueOf(commandSplit[2]);
        int noOfSlotsPerFloor = Integer.valueOf(commandSplit[3]);
        //create the parking lot with specified floor and slots
        List<Floor> floors = createFloors(noOfFloors, parkingLotId, noOfSlotsPerFloor);
        return new ParkingLot(parkingLotId, floors);
    }

    public static List<Floor> createFloors(int noOfFloors, String parkingLotId, int noOfSlotsPerFloor){
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < noOfFloors; i++){
            //Create a floor object for each floor
            ParkingLotService.createFloor(parkingLotId, i + 1, noOfSlotsPerFloor, floors);
        }
        return floors;
    }

    public static void createFloor(String parkingLotId, int serialNumber, int noOfSlotsPerFloor, List<Floor> floors){
        Floor floor = new Floor(parkingLotId + "_" + serialNumber, serialNumber);
        List<ParkingSlot> slots = createParkingSlots(noOfSlotsPerFloor, floor);
        floor.setParkingSlots(slots);
        floors.add(floor);
    }

    public static List<ParkingSlot> createParkingSlots(int noOfSlotsPerFloor, Floor floor){
        List<ParkingSlot> slots = new ArrayList<>();
        for(int j = 0; j < noOfSlotsPerFloor; j++){
            System.out.println("value of j: " + j);
            ParkingLotService.createParkingSlot(j + 1, slots, floor);
        }
        return slots;
    }

    public static void createParkingSlot(int slotNumber, List<ParkingSlot> slots, Floor floor){
        //create as many parking slot required per floor
        String vehicleType;
        if (slotNumber == 1) vehicleType = "truck";
        else if (slotNumber < 4) vehicleType = "bike";
        else vehicleType = "car";
        ParkingSlot slot = new ParkingSlot(slotNumber, floor, vehicleType);
        slots.add(slot);
    }
}
