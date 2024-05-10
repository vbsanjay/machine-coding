package services;

import models.Point;
import models.Taxi;

import java.util.List;
import java.util.Scanner;

public class UserCommandService {
    public void processUserCommands(List<Taxi> taxis, List<Point> points){
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while(loop){
            PrintService.getWhatUserNeedToDo();
            int userInput = sc.nextInt();
            switch (userInput){
                case 1:
                    BookingService bookingService = new BookingService();
                    bookingService.bookTaxi(taxis, points);
                    break;
                case 2:
                    DisplayService displayService = new DisplayService();
                    displayService.showAllTaxiDetails();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    PrintService.invalidOption();
            }
        }
        sc.close();
    }
}
