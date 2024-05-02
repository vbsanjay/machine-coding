package service;

import models.CarRentalArea;
import models.Platform;
import models.Vehicle;
import models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class CarRentalAreaCreationService {

    public static CarRentalArea createCarRentalArea(int noOfPlatforms,
                                                    int noOfSUVsPerPlatform, int noOfHatchbacksPerPlatform,
                                                    int noOfSedansPerPlatform, int noOfBikesPerPlatform){
        List<Platform> platforms = CarRentalAreaCreationService.createPlatforms(noOfPlatforms, noOfSUVsPerPlatform,
                noOfHatchbacksPerPlatform, noOfSedansPerPlatform, noOfBikesPerPlatform);

        CarRentalArea carRentalArea = new CarRentalArea(noOfPlatforms,
                noOfSUVsPerPlatform, noOfHatchbacksPerPlatform,
                noOfSedansPerPlatform, noOfBikesPerPlatform, platforms);

        return carRentalArea;

    }

    public static List<Platform> createPlatforms(int noOfPlatforms,
                                                 int noOfSUVsPerPlatform, int noOfHatchbacksPerPlatform,
                                                 int noOfSedansPerPlatform, int noOfBikesPerPlatform){
        List<Platform> platforms = new ArrayList<>();
        for(int i = 0; i < noOfPlatforms; i++){
            List<Vehicle> vehicles = CarRentalAreaCreationService.createVehicles(noOfSUVsPerPlatform, noOfHatchbacksPerPlatform, noOfSedansPerPlatform, noOfBikesPerPlatform);
            platforms.add(new Platform(i+1, vehicles));
        }

        return platforms;
    }

    public static List<Vehicle> createVehicles(int noOfSUVsPerPlatform, int noOfHatchbacksPerPlatform,
                                                int noOfSedansPerPlatform, int noOfBikesPerPlatform){
        List<Vehicle> vehicles = new ArrayList<>();
        for(int i = 0; i < noOfSUVsPerPlatform; i++){
            vehicles.add(new Vehicle(CarRentalAreaCreationService.numberPlateGenerator(), VehicleType.SUV));
        }
        for(int i = 0; i < noOfHatchbacksPerPlatform; i++){
            vehicles.add(new Vehicle(CarRentalAreaCreationService.numberPlateGenerator(), VehicleType.HATCHBACK));
        }
        for(int i = 0; i < noOfSedansPerPlatform; i++){
            vehicles.add(new Vehicle(CarRentalAreaCreationService.numberPlateGenerator(), VehicleType.SEDAN));
        }
        for(int i = 0; i < noOfBikesPerPlatform; i++){
            vehicles.add(new Vehicle(CarRentalAreaCreationService.numberPlateGenerator(), VehicleType.BIKE));
        }

        return vehicles;
    }

    static int district = 10;
    static int localNumber = 999;
    public static String numberPlateGenerator(){
        String state = "TN";
        localNumber = (localNumber == 10000)? 1000: localNumber + 1;
        if (localNumber == 9999) district = (district + 1)  % 23;
        return state + " " + district + " " + localNumber;
    }
}
