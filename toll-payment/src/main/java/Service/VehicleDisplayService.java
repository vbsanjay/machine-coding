package Service;

import Entity.Journey;
import Entity.Vehicle;
import Repository.TollPaymentApplicationRepository;

import java.util.List;

public class VehicleDisplayService {
    public static void displayAllVehicleDetails(){
        List<Vehicle> vehicles = TollPaymentApplicationRepository.getVehicles();
        for(int i = 0; i < vehicles.size(); i++){
            Vehicle currentVehicle = vehicles.get(i);
            System.out.println("Details of Vehicle: " + currentVehicle.getRegistrationNumber() + " --------------------------------------------------------");
            System.out.printf("%5s %15s %15s %20s %20s%n", "Sl.no", "Start Point", "End Point", "Number of Tolls", "Total Amount Paid");
            System.out.println("---------------------------------------------------------------------------------");
            List<Journey> journeys = currentVehicle.getJourneys();
            for(int j = 0; j < journeys.size(); j++){
                Journey currentJourney = journeys.get(j);
                System.out.printf("%5s %15s %15s %20s %20s%n", j+1, currentJourney.getStart(), currentJourney.getEnd(), currentJourney.getBills().size(), currentJourney.getAmountSpent());
            }
            System.out.println();
        }
    }
}
