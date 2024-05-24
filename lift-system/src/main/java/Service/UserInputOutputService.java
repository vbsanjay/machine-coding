package Service;

import java.util.Scanner;

public class UserInputOutputService {
    static Scanner sc = new Scanner(System.in);
    public static int getNumberOfLiftFromUser(){
        System.out.print("Enter the number of lift you need: ");
        return sc.nextInt();
    }
    public static int getStartPointFromUser(){
        System.out.print("Start Point of the lift: ");
        return sc.nextInt();
    }
    public static int getEndPointFromUser(){
        System.out.print("End Point of the lift: ");
        return sc.nextInt();
    }
}
