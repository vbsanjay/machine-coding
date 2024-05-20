package Service;

import java.util.Scanner;

public class UserInputOutputService {
    static Scanner sc = new Scanner(System.in);
    public static int fetchChoiceFromUser(){
        System.out.println("1. Display all employee details in table format");
        System.out.println("2. Search employee record");
        return sc.nextInt();
    }

    public static int fetchSearchChoiceFromUser(){
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.println("4. Designation");
        System.out.println("5. Department");
        System.out.println("6. Reporting To");
        return sc.nextInt();
    }

    public static String fetchStingFromUser(String property){
        System.out.println("Please Enter the " + property + " :");
        return sc.next();
    }

    public static boolean continueSearch(){
        System.out.println("Do you want to continue search?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int userChoice = sc.nextInt();
        if(userChoice == 1) return true;
        else return false;
    }

    public static int fetchOperationFromUser(){
        System.out.println("Choose any string operations from below list");
        System.out.println("1. Equals \n" +
                "2. Not Equals \n" +
                "3. Contains \n" +
                "4. Not contains \n" +
                "5. Starts with \n" +
                "6. Ends with");
        return sc.nextInt();
    }

    public static int fetchIntegerOperationFromUser(){
        //<, >, =, !=, between
        System.out.println("1. Choose numbers lesser than");
        System.out.println("2. Choose numbers greater than");
        System.out.println("3. Choose numbers equal to");
        System.out.println("4. Choose numbers not equal to");
        System.out.println("5. Choose numbers between");
        return sc.nextInt();
    }

    public static int fetchIntegerFromUser(String property){
        System.out.println("Please Enter the " + property + " :");
        return sc.nextInt();
    }

    public static int[] fetchIntegerBetweenFromUser(String property){
        int startAndEndValue[] = new int[2];
        System.out.println("Please Enter the start " + property + ": ");
        startAndEndValue[0] = sc.nextInt();
        System.out.println("Please Enter the end " + property + ": ");
        startAndEndValue[1] = sc.nextInt();
        return startAndEndValue;
    }
}
