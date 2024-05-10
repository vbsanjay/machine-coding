package services;

import models.Point;
import models.Ride;
import models.Taxi;
import models.TimeSlot;

import java.util.List;
import java.util.Optional;

public class BookingService {
    private int customerID;
    private int pickupPoint;
    private int dropPoint;
    private int pickupTime;
    private int dropTime;
    private int rideAmount;

    public void bookTaxi(List<Taxi> taxis, List<Point> points){
        getBookingDetails();
        Optional<Taxi> optionalTaxi = bookNearestTaxi(points, pickupPoint, pickupTime);
        if (optionalTaxi.isPresent()) { // Check if a taxi is found
            Taxi availableTaxi = optionalTaxi.get(); // Get the actual Taxi object
            // Proceed with booking the taxi
            System.out.println("Taxi can be allocated ✅");
            System.out.println("Taxi - " + availableTaxi.getId() + " is allotted 🚕");
            // additional booking logic...
            dropTime = calculateDropTime(pickupTime, pickupPoint, dropPoint);
            TimeSlot timeSlot = new TimeSlot(pickupTime, dropTime);
            rideAmount = calculateRideAmount(pickupPoint, dropPoint);
            Ride ride = new Ride(pickupPoint, dropPoint, timeSlot, rideAmount);
            availableTaxi.getRides().add(ride);
            availableTaxi.setTotalEarning(availableTaxi.getTotalEarning() + rideAmount);
            availableTaxi.getOccupiedTimeSlots().add(timeSlot);
            points.get(dropPoint - 1);
        } else {
            // Handle the case where no taxi is available
            System.out.println("No taxi available at the specified time.");
        }
    }
    public void getBookingDetails(){
        UserIOService userIOService = new UserIOService();
        userIOService.getBookingDetailsFromUser();
        customerID = userIOService.getCustomerID();
        pickupPoint = userIOService.getPickupPoint();
        dropPoint = userIOService.getDropPoint();
        pickupTime = userIOService.getPickupTime();
    }

    public Optional<Taxi> bookNearestTaxi(List<Point> points, int pickupPoint, int pickupTime){
        Taxi nearestTaxi = null;
        int nearestDistance = Integer.MAX_VALUE;
        int lowestEarnings = Integer.MAX_VALUE;

        for (Point point : points) {
            int distance = Math.abs(pickupPoint - point.getName() - 'A' + 1);
            if (distance <= nearestDistance){
                for (Taxi taxi : point.getTaxis()){
                    if (taxi.isAvailable(pickupTime)){
                        if(distance < nearestDistance || (distance == nearestDistance && taxi.getTotalEarning() < lowestEarnings)){
                            nearestTaxi = taxi;
                            lowestEarnings = taxi.getTotalEarning();
                            nearestDistance = distance;
                        }
                    }
                }
            }
        }

        return Optional.ofNullable(nearestTaxi);
    }

    public int calculateDropTime(int pickupTime, int pickupPoint, int dropPoint){
        return pickupTime + (dropPoint - pickupPoint);
    }

    public int calculateRideAmount(int pickupPoint, int dropPoint){
        int amount = 0;
        for(int i = pickupPoint; i < dropPoint; i++){
            if(i == pickupPoint) amount = amount + 150;
            else amount = amount + 100;
        }
        return amount;
    }

}
