package Service;

import java.util.Scanner;

public class UserInputOutputService {
    static Scanner scanner = new Scanner(System.in);
    public static int getRequiredService(){
        DisplayService.displayAvailableService();
        return scanner.nextInt();
    }

    public static int getRequiredCoach(){
        DisplayService.displayCoach();
        return scanner.nextInt();
    }

    public static int getTicketIdFromUser(){
        DisplayService.displayCancelTicketID();
        return scanner.nextInt();
    }

    public static String getUserName(){
        DisplayService.displayEnterName();
        return scanner.next();
    }
}
