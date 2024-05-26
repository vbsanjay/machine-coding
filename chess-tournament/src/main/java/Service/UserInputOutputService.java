package Service;

import java.util.Scanner;

public class UserInputOutputService {
    static Scanner sc = new Scanner(System.in);
    public static int fetchNumberOfPlayerFromUser(){
        System.out.print("Please enter the number of players in the tournament: ");
        return sc.nextInt();
    }
}
