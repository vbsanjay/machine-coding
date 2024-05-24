package Service;

import Entity.Lift;
import Repository.LiftSystemRepository;

import java.util.List;

public class DisplayService {
    public static void displayLiftPositions(){
        List<Lift> totalList = LiftSystemRepository.getTotalList();
        System.out.println();
        System.out.printf("%10s %15s %15s %n", "Lift Number", "Lift Position", "Current Dir");
        System.out.println("--------------------------------------------");
        for(int i = 0; i < totalList.size(); i++){
            String direction = (totalList.get(i).isDown())? "Down":"Up";
            System.out.printf("%10d %15d %15s %n", totalList.get(i).getLiftNumber(), totalList.get(i).getFloorNumber(), direction);
        }
        System.out.println();
    }
}
