package Controller;

import Service.PrepareChartService;
import Service.StatusCheckingService;
import Service.TicketBookingService;
import Service.TicketCancellationService;

public class TicketController {
    public static void bookTicket(){
        TicketBookingService.bookTicket();
    }
    public static void cancelTicket(){
        TicketCancellationService.cancelTicket();
    }
    public static void checkStatus(){
        StatusCheckingService.checkTicketStatus();
    }
    public static void prepareChart(){
        PrepareChartService.displayChart();
    }
}
