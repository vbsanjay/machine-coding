package Service;

import Entity.*;
import Repository.TollPaymentApplicationRepository;

import java.util.ArrayList;
import java.util.List;

public class JourneyService {
    public static void journeyGenerator(){
        Vehicle vehicle = UserInputOutputService.fetchTheVehicleToUseFromUser(TollPaymentApplicationRepository.getVehicles());
        int startPoint = UserInputOutputService.fetchStartPointFromUser();
        int endPoint = UserInputOutputService.fetchEndPointFromUser();
        List<Toll> shortestTollPath = findShortestTollPath(startPoint, endPoint);
        List<Bill> billsGenerated = new ArrayList<>();
        int amount = findTheTotalPaidInTolls(shortestTollPath, vehicle, billsGenerated);
        System.out.println("The total Amount Paid: " + amount);
        // Adding the journey to the vehicle
        // This help to retrieve all the journey a vehicle has made
        Journey journey = new Journey(startPoint, endPoint, amount, vehicle);
        journey.setBills(billsGenerated);
        vehicle.getJourneys().add(journey);
    }

    public static List<Toll> findShortestTollPath(int startPoint, int endPoint){
        List<Toll> totalTolls = TollPaymentApplicationRepository.getTolls();
        List<Toll> shortestTollPath = new ArrayList<>();
        int clockwiseDirection = 0;
        int counterClockwiseDirection = 0;
        if(endPoint > startPoint){
            clockwiseDirection = endPoint - startPoint;
            counterClockwiseDirection = TollPaymentApplicationRepository.getTotalNumberOfTolls() - clockwiseDirection;
        }
        else{
            counterClockwiseDirection = startPoint - endPoint;
            clockwiseDirection = TollPaymentApplicationRepository.getTotalNumberOfTolls() - counterClockwiseDirection;

        }

        if(startPoint < endPoint){
            if(clockwiseDirection < counterClockwiseDirection) {
                // move forward
                for(int i = startPoint - 1 ; i < endPoint; i++){
                    shortestTollPath.add(totalTolls.get(i));
                }
            }
            else{
                // move anticlockwise
                int i = counterClockwiseDirection;
                int index = startPoint - 1;
                while(i > -1){
                    if (index == -1) index = TollPaymentApplicationRepository.getTotalNumberOfTolls() - 1;
                    shortestTollPath.add(totalTolls.get(index));
                    index--;
                    i--;
                }
            }
        }
        else if (startPoint > endPoint){
            if(clockwiseDirection < counterClockwiseDirection) {
                // move forward
                int i = clockwiseDirection;
                int index = startPoint - 1;
                while(i > -1){
                    if (index == TollPaymentApplicationRepository.getTotalNumberOfTolls()) index = 0;
                    shortestTollPath.add(totalTolls.get(index));
                    index++;
                    i--;
                }
            }
            else{
                // move anticlockwise
                for(int i = startPoint - 1 ; i >= endPoint - 1; i--){
                    shortestTollPath.add(totalTolls.get(i));
                }
            }
        }
        return shortestTollPath;
    }

    public static int findTheTotalPaidInTolls(List<Toll> tollPath, Vehicle vehicle, List<Bill> billsGenerated){
        String vehicleType = vehicle.getVehicleType();
        boolean vip = vehicle.isVip();
        int totalAmount = 0;
        for(int i = 0; i < tollPath.size(); i++){
            Toll currentToll = tollPath.get(i);
            System.out.println("Vehicle crossing toll " + currentToll.getTollNumber() + "....");
            ChargingScheme chargingSchemeAtToll = currentToll.getChargingScheme();
            int rateAtTheToll = getRateAtTheToll(vehicleType, chargingSchemeAtToll);
            System.out.println("Amount charger: " + rateAtTheToll);
            // Check if the vehicle is VIP
            if(vip){
                int discount20 = (rateAtTheToll / 100) * 20;
                System.out.println("VIP discount applied!!!");
                System.out.printf("%10s %10s%n", "toll rate", "discount");
                System.out.println("-----------------------");
                System.out.printf("%10d %10d%n", rateAtTheToll, discount20);
                rateAtTheToll = (vip)? rateAtTheToll - discount20:rateAtTheToll;
            }
            totalAmount += rateAtTheToll;
            // We generate bill at each toll.
            // This helps to display the toll details.
            Bill bill = new Bill(vehicle, currentToll, rateAtTheToll);
            billsGenerated.add(bill);
            currentToll.getBills().add(bill);
        }
        return totalAmount;
    }

    private static int getRateAtTheToll(String vehicleType, ChargingScheme chargingSchemeAtToll) {
        int rateAtTheToll = 0;
        if(vehicleType.equals("BIKE")){
            rateAtTheToll = chargingSchemeAtToll.getBikeRate();
        }
        else if(vehicleType.equals("CAR")){
            rateAtTheToll = chargingSchemeAtToll.getCarRate();
        }
        else if(vehicleType.equals("TRUCK")){
            rateAtTheToll = chargingSchemeAtToll.getTruckRate();
        }
        else{
            rateAtTheToll = chargingSchemeAtToll.getOverSizedVehicleRate();
        }
        return rateAtTheToll;
    }
}
