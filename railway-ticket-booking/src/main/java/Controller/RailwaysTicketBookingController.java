package Controller;

import Service.UserInputOutputService;

public class RailwaysTicketBookingController {
    public static void startRailwayTicketBookingApplication(){
        boolean loop = true;
        while(loop){
            int userChoice = UserInputOutputService.getRequiredService();
            switch(userChoice){
                case 1:
                    TicketController.bookTicket();
                    break;
                case 2:
                    TicketController.cancelTicket();
                    break;
                case 3:
                    TicketController.checkStatus();
                    break;
                case 4:
                    TicketController.prepareChart();
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }
    }
}
