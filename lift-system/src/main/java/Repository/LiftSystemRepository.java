package Repository;

import Entity.Lift;
import Service.DisplayService;
import Service.UserInputOutputService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiftSystemRepository {
    static List<Lift> totalList = new ArrayList<>();
    static int numberOfLift;
    static Map<Lift, List<Integer>> floorsAllowedTracker = new HashMap<>();

    public static void createStartupEnvironment(){
        numberOfLift = UserInputOutputService.getNumberOfLiftFromUser();
        createLift(numberOfLift);
        updateRestriction();
        DisplayService.displayLiftPositions();
    }

    public static void createLift(int numberOfLift){
        for(int i = 0; i < numberOfLift; i++){
            totalList.add(new Lift(i+1, false));
        }
    }

    public static void updateRestriction(){
        for(int i = 0; i < numberOfLift; i++){
            Lift currLift = totalList.get(i);
            List<Integer> floorsAllowed = new ArrayList<>();
            if(currLift.getLiftNumber() == 1 || currLift.getLiftNumber() == 2){
                for(int j = 0; j <= 5; j++){
                    floorsAllowed.add(j);
                }
            }
            else if(currLift.getLiftNumber() == 3 || currLift.getLiftNumber() == 4){
                floorsAllowed.add(0);
                for(int j = 6; j <= 10; j++){
                    floorsAllowed.add(j);
                }
            }
            else{
                for(int j = 0; j <= 10; j++){
                    floorsAllowed.add(j);
                }
            }
            floorsAllowedTracker.put(currLift, floorsAllowed);
        }
    }

    public static List<Lift> getTotalList() {
        return totalList;
    }

    public static void setTotalList(List<Lift> totalList) {
        LiftSystemRepository.totalList = totalList;
    }

    public static int getNumberOfLift() {
        return numberOfLift;
    }

    public static void setNumberOfLift(int numberOfLift) {
        LiftSystemRepository.numberOfLift = numberOfLift;
    }

    public static Map<Lift, List<Integer>> getFloorsAllowedTracker() {
        return floorsAllowedTracker;
    }

    public static void setFloorsAllowedTracker(Map<Lift, List<Integer>> floorsAllowedTracker) {
        LiftSystemRepository.floorsAllowedTracker = floorsAllowedTracker;
    }
}
