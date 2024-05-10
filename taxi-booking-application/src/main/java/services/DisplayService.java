package services;

import models.Ride;
import models.Taxi;

import java.util.List;

public class DisplayService {
    public void showAllTaxiDetails(List<Taxi> taxis){
        for(int i = 0; i < taxis.size(); i++){
            Taxi taxi = taxis.get(i);
            System.out.println("Taxi - " + taxi.getId());
            System.out.println("Total Earnings: " + taxi.getTotalEarning());
            List<Ride> rides = taxi.getRides();
            for(int j = 0; j < rides.size(); j++){
                Ride ride = rides.get(j);
                System.out.println("BookingID 📝: " + ride.getId() + " ┃ CustomerID 🪪: " + ride.getCustomerID() + " ┃ From 📍: " + (char)(ride.getStartPoint() + 'A') + " ┃ To 📍: " +  (char)(ride.getEndPoint() + 'A') + " ┃ PickupTime ⏰: " + ride.getTimeSlot().getStart()  + " ┃ DropTime ⏰: " + ride.getTimeSlot().getEnd() + " ┃ Amount 💸: " + ride.getAmount());
            }
        }
    }
}
