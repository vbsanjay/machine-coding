package Service;

import Entity.ChargingScheme;
import Entity.Toll;
import Entity.Vehicle;
import Repository.TollPaymentApplicationRepository;

import java.util.ArrayList;
import java.util.List;

public class JourneyService {
    public static void journeyGenerator(){
        Vehicle vehicle = UserInputOutputService.fetchTheVehicleToUseFromUser(TollPaymentApplicationRepository.getVehicles());
        int startPoint = UserInputOutputService.fetchStartPointFromUser();
        int endPoint = UserInputOutputService.fetchEndPointFromUser();
        List<Toll> shortestTollPath = findShortestTollPath(startPoint, endPoint);
        int amount = findTheTotalPaidInTolls(shortestTollPath, vehicle);
        System.out.println("The total Amount Paid: " + amount);
        //Journey journey = new Journey(startPoint, endPoint, )
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

    public static int findTheTotalPaidInTolls(List<Toll> tollPath, Vehicle vehicle){
        String vehicleType = vehicle.getVehicleType();
        int totalAmount = 0;
        for(int i = 0; i < tollPath.size(); i++){
            System.out.println("Vehicle crossing toll " + tollPath.get(i).getTollNumber() + "....");
            ChargingScheme chargingSchemeAtToll = tollPath.get(i).getChargingScheme();
            int rateAtTheToll = getRateAtTheToll(vehicleType, chargingSchemeAtToll);
            System.out.println("Amount charger: " + rateAtTheToll);
            totalAmount += rateAtTheToll;
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
