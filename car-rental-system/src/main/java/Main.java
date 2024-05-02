import models.CarRentalArea;
import models.Platform;
import models.Vehicle;
import repository.CarRentalAreaRepo;
import service.InitialSetupService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a Car Rental Application
        // Car rental unit has n number of floors
        CarRentalAreaRepo carRentalAreaRepo = InitialSetupService.initialSetup();
        CarRentalArea carRentalArea = carRentalAreaRepo.getCarRentalArea();
        List<Platform> platforms =  carRentalArea.getPlatforms();

        for(int i = 0; i < platforms.size(); i++){
            Platform platform = platforms.get(i);
            printAllVehicle(platform);
        }
    }

    public static void printAllVehicle(Platform platform){
        List<Vehicle> vehicles = platform.getVehicles();

        for(int i = 0; i < vehicles.size(); i++){
            System.out.println("Platform Number:" + platform.getPlatformId() + " Vehicle Number: " + vehicles.get(i).getRegisterNumber() + " Vehicle type: " + vehicles.get(i).getVehicleType());
        }
    }
}