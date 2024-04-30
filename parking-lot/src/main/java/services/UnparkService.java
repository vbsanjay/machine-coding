package services;

import models.Ticket;
import models.Vehicle;

public class UnparkService {
    public static void unparkVehicle(int id){
        Ticket ticket = ParkingService.ticketMap.get(id);
        //Make the slot free
        Vehicle vehicle = ticket.getVehicle();
        vehicle.getParkingSlot().setFree(true);
        vehicle.setFloor(null);
        System.out.println("Vehicle has been successfully unparked.");
    }
}
