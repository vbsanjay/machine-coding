package service;

import models.CarRentalArea;
import repository.CarRentalAreaRepo;

import java.util.Scanner;

public class InitialSetupService {
    public static CarRentalAreaRepo initialSetup(){
        System.out.println("WELCOME TO CAR RENTAL SERVICE");
        System.out.println("-----------------------------------------------------");
        System.out.println("We need to create a car rental area. Please provide the below details");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of platforms your car rental area required: ");
        int noOfPlatforms = sc.nextInt();
        System.out.print("Enter the number of SUVs per floor: ");
        int noOfSUVsPerPlatform = sc.nextInt();
        System.out.print("Enter the number of Hatchbacks per floor: ");
        int noOfHatchbacksPerPlatform = sc.nextInt();
        System.out.print("Enter the number of Sedans per floor: ");
        int noOfSedansPerPlatform = sc.nextInt();
        System.out.print("Enter the number of bikes per floor: ");
        int noOfBikesPerPlatform = sc.nextInt();

        CarRentalArea carRentalArea = CarRentalAreaCreationService.createCarRentalArea(noOfPlatforms, noOfSUVsPerPlatform,
                noOfHatchbacksPerPlatform, noOfSedansPerPlatform, noOfBikesPerPlatform);

        return new CarRentalAreaRepo(carRentalArea);
    }
}
