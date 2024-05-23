package Service;

import java.util.Scanner;

public class InputOutputService {
    static Scanner sc = new Scanner(System.in);
    public static int getNumberOfRowsFromUser(){
        System.out.print("Enter the number of Rows for the game: ");
        return sc.nextInt();
    }

    public static int getNumberOfColumnFromUser(){
        System.out.print("Enter the number of Column for the game: ");
        return sc.nextInt();
    }
    public static int getColumnFromUser(){
        System.out.print("Enter the column you need to fill: ");
        return sc.nextInt();
    }
    public static String getColorFromUser(){
        System.out.print("Enter the color you need to fill: ");
        return sc.next();
    }
    public static int fetchVersionRequiredFromUser(){
        System.out.println("1. Version 1: When all the columns the filled the game is over.");
        System.out.println("2. Version 2: When any one of the column is filled the game is over");
        System.out.println("3. Version 3: Column is filled only if the previous row is filled and when any one of the column is filled the game is over");
        System.out.println("4. Version 4: Balloons bust when same color seen in column");
        System.out.println("5. Version 5: Balloons bust when same color seen in row or column");
        System.out.println("6. Exit the application");
        return sc.nextInt();
    }

    public static String doWantToContinueGame(){
        System.out.println("Do you want to continue the Game? Yes/No");
        return sc.next();
    }
}
