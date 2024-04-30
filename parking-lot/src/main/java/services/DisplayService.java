package services;

import models.ParkingLot;
import models.ParkingSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayService {
    public static void displayData(String displayType, String vehicleType, ParkingLot parkingLot){
        if (displayType.equals("free_count")){
            DisplayService.calculateFreeCount(parkingLot, vehicleType);
        }
        else if (displayType.equals("free_slots")){
            DisplayService.calculateFreeSlots(parkingLot, vehicleType);
        }
        else if (displayType.equals("occupied_slots")){
            DisplayService.calculateOccupiedSlots(parkingLot, vehicleType);
        }
        else{
            System.out.println("Invalid input. Enter the valid data");
            return;
        }
    }

    public static void calculateFreeCount(ParkingLot parkingLot, String vehicleType){
        List<ParkingSlot> freeSlots = ParkingLotService.freeSlots;
        int[] counter = new int[parkingLot.getNoOfFloors()];
        for(int i = 0; i < freeSlots.size(); i++){
            ParkingSlot currSlot = freeSlots.get(i);
            String vehType = currSlot.getVehicleType();
            if (vehType.equals(vehicleType)){
                counter[currSlot.getFloor().getFloorNumber() - 1]++;
            }
        }
        for(int i = 0; i < counter.length; i++){
            System.out.println("No. of free slots for " +  vehicleType + "on Floor " + (i + 1) + ": " + counter[i]);
        }
    }

    public static void calculateFreeSlots(ParkingLot parkingLot, String vehicleType){
        List<ParkingSlot> freeSlots = ParkingLotService.freeSlots;

        HashMap<Integer, List<Integer>> freeSlotTracker = new HashMap<>();
        for(int i = 1; i <= parkingLot.getFloors().size(); i++){
            freeSlotTracker.put(i, new ArrayList<>());
        }

        for(int i = 0; i < freeSlots.size(); i++){
            ParkingSlot currSlot = freeSlots.get(i);
            String vehType = currSlot.getVehicleType();
            if (vehType.equals(vehicleType)){
                List<Integer> ls = freeSlotTracker.get(currSlot.getFloor().getFloorNumber());
                ls.add(currSlot.getId());
                freeSlotTracker.put(currSlot.getFloor().getFloorNumber(), ls);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : freeSlotTracker.entrySet()) {
            int floorNumber = entry.getKey();
            List<Integer> slotsInEachFloor = entry.getValue();
            System.out.print("free slots in floor " + floorNumber + ": ");
            for(int i = 0; i < slotsInEachFloor.size(); i++){
                System.out.print(slotsInEachFloor.get(i) + " ");
            }
            System.out.println();
        }

    }

    public static void calculateOccupiedSlots(ParkingLot parkingLot, String vehicleType){
        List<ParkingSlot> occupiedSlot = ParkingLotService.occupiedSlots;

        HashMap<Integer, List<Integer>> occupiedSlotTracker = new HashMap<>();
        for(int i = 1; i <= parkingLot.getFloors().size(); i++){
            occupiedSlotTracker.put(i, new ArrayList<>());
        }

        for(int i = 0; i < occupiedSlot.size(); i++){
            ParkingSlot currSlot = occupiedSlot.get(i);
            String vehType = currSlot.getVehicleType();
            if (vehType.equals(vehicleType)){
                List<Integer> ls = occupiedSlotTracker.get(currSlot.getFloor().getFloorNumber());
                ls.add(currSlot.getId());
                occupiedSlotTracker.put(currSlot.getFloor().getFloorNumber(), ls);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : occupiedSlotTracker.entrySet()) {
            int floorNumber = entry.getKey();
            List<Integer> slotsInEachFloor = entry.getValue();
            System.out.print("occupied slots in floor " + floorNumber + ": ");
            for(int i = 0; i < slotsInEachFloor.size(); i++){
                System.out.print(slotsInEachFloor.get(i) + " ");
            }
            System.out.println();
        }

    }
}
