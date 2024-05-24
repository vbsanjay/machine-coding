package Service;

import Entity.Lift;
import Repository.LiftSystemRepository;

import java.util.*;

public class LiftService {
    public static void operateLift(){
        int startPoint = UserInputOutputService.getStartPointFromUser();
        int endPoint = UserInputOutputService.getEndPointFromUser();
        assignLift(startPoint, endPoint);
        DisplayService.displayLiftPositions();
    }
    public static void assignLift(int startPoint, int endPoint){
        // find the eligible lifts
        List<Lift> eligibleLift = findEligibleLifts(startPoint, endPoint);
        // find the shortest path of the eligible lift
        Comparator<Lift> customSort = new Comparator<Lift>() {
            @Override
            public int compare(Lift L1, Lift L2) {
                // get the current position of lift for calculations
                int L1position = L1.getFloorNumber();
                int L2position = L2.getFloorNumber();
                // calculate current position to start point distance
                int L1distance = Math.abs(L1position - startPoint);
                int L2distance = Math.abs(L2position - startPoint);
                // calculate the distance form start to end point
                int L1travel = L1distance;
                int L2travel = L2distance;
                Map<Lift, List<Integer>> allowedFloorsTracker = LiftSystemRepository.getFloorsAllowedTracker();
                for(int i = startPoint; i <= endPoint; i++){
                    List<Integer> availableFloors = allowedFloorsTracker.get(L1);
                    if(availableFloors.contains(i - 1)){
                        L1travel++;
                    }
                }
                for(int i = startPoint; i <= endPoint; i++){
                    List<Integer> availableFloors = allowedFloorsTracker.get(L2);
                    if(availableFloors.contains(i - 1)){
                        L2travel++;
                    }
                }

                // ture if down
                boolean currDirection = (startPoint < endPoint)? false: true;

                if(L1travel == L2travel){
                    if(L1.isDown() == currDirection){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
                else if (L1travel < L2travel){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        };
        Collections.sort(eligibleLift, customSort);
        if(eligibleLift.isEmpty()){
            System.out.println("No lift is available!");
            return;
        }
        Lift liftNearest = eligibleLift.getFirst();
        liftNearest.setFloorNumber(endPoint);
        if(endPoint != 10 && startPoint < endPoint){
            liftNearest.setDown(false);
        }
        else{
            liftNearest.setDown(true);
        }

    }

    public static List<Lift> findEligibleLifts(int startPoint, int endPoint){
        List<Lift> eligibleLift = new ArrayList<>();
        List<Lift> totalLift = LiftSystemRepository.getTotalList();
        Map<Lift, List<Integer>> allowedFloorsTracker = LiftSystemRepository.getFloorsAllowedTracker();

        for(int i = 0; i < totalLift.size(); i++){
            Lift currLift = totalLift.get(i);
            List<Integer> availableFloors = allowedFloorsTracker.get(currLift);
            if(availableFloors.contains(startPoint) && availableFloors.contains(endPoint)){
                eligibleLift.add(currLift);
            }
        }

        return eligibleLift;
    }
}
