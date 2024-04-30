package services;

import models.*;

import java.util.HashMap;
import java.util.List;

public class ParkingService {
    static HashMap<Integer, Ticket> ticketMap = new HashMap<Integer, Ticket>();
    public static void parkVehicle(String vehicleType, String regNo, String color, ParkingLot parkingLot){
        Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
        ParkingSlot availableSlot = ParkingService.getFirstAvailableSlot(vehicleType, parkingLot);
        if(availableSlot == null){
            System.out.println("The parking lot is full");
            return;
        }
        vehicle.setParkingSlot(availableSlot);
        vehicle.setFloor(availableSlot.getFloor());
        Ticket myTicket = ParkingService.generateTicket(parkingLot, availableSlot, vehicle);
        ticketMap.put(myTicket.getId(), myTicket);
        System.out.println("Vehicle has been parked and ticket has been generated");
        System.out.println("Your Ticket ID: " + myTicket.getId());
    }

    public static ParkingSlot getFirstAvailableSlot(String vehicleType, ParkingLot parkingLot){
        //Iterate over each floor
        List<Floor> floors = parkingLot.getFloors();
        int limits[] = getLimit(vehicleType, parkingLot);
        int start = limits[0];
        int end = limits[1];

        for(Floor floor: floors){
                List<ParkingSlot> parkingSlots = floor.getParkingSlots();
                for (int i = start; i <=end; i++){
                    ParkingSlot currentSlot = parkingSlots.get(i);
                    if(currentSlot.isFree()){
                        return currentSlot;
                    }
                }
        }
        return null;
    }

    public static int[] getLimit(String vehicleType, ParkingLot parkingLot){
        int limits[] = new int[2];
        if(vehicleType.equals("truck")){
            limits[0] = 0;
            limits[1] = 0;
        }
        else if(vehicleType.equals("bike")){
            limits[0] = 1;
            limits[1] = 2;
        }
        else if(vehicleType.equals("car")){
            limits[0] = 3;
            limits[1] = parkingLot.getNoOfSlotsPerFloor();
        }
        return limits;
    }

    public static Ticket generateTicket(ParkingLot parkingLot, ParkingSlot slotToBeBooked, Vehicle vehicle){
        slotToBeBooked.setFree(false);
        vehicle.setFloor(slotToBeBooked.getFloor());
        vehicle.setParkingSlot(slotToBeBooked);
        Ticket ticket = new Ticket(parkingLot, slotToBeBooked.getFloor(), slotToBeBooked, vehicle);
        return  ticket;
    }
}
