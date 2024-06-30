package Service;

import Model.Ticket;
import Repository.RailwayTicketBookingRepository;

import java.util.HashMap;
import java.util.Map;

public class PrepareChartService {
    static HashMap<Integer, Ticket> allTickets = RailwayTicketBookingRepository.getAllTickets();
    public static void displayChart(){
        int coachChoice = UserInputOutputService.getRequiredCoach();
        switch (coachChoice){
            case 1:
                displayACCoach();
                break;
            case 2:
                displayNonAcCoach();
                break;
            case 3:
                displaySeaterCoach();
                break;
        }
    }
    public static void displayACCoach(){
        displayChart("AC_COACH");
    }
    public static void displayNonAcCoach(){
        displayChart("NON_AC_COACH");
    }
    public static void displaySeaterCoach(){
        displayChart("SEATER_COACH");
    }

    public static void displayChart(String coach){
        System.out.printf("%8s | %15s | %10s | %15s | %15s | %15s |\n", "Sl. No", "Ticket Number","Name", "Coach", "Seat Number", "Status");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Ticket> entry : allTickets.entrySet()) {
            int sl_no = 1;
            if(entry.getValue().getCoach().equals(coach)){
                Ticket currentTicket = entry.getValue();
                int ticketId = currentTicket.getTicketId();
                String name = currentTicket.getName();
                int seatNumber = currentTicket.getSeatNumber();
                String status = (currentTicket.isStatus())? "Confirmed":"Waiting";
                System.out.printf("%8d | %15d | %10s | %15s | %15d | %15s |\n", sl_no, ticketId, name, coach, seatNumber, status);
                sl_no+=1;
            }
        }
    }
}
