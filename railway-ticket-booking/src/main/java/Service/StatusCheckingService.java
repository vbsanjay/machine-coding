package Service;

import Model.Ticket;
import Repository.RailwayTicketBookingRepository;

import java.util.HashMap;

public class StatusCheckingService {
    static HashMap<Integer, Ticket> allTickets = RailwayTicketBookingRepository.getAllTickets();
    static boolean[] acCoachSeats = RailwayTicketBookingRepository.getAcCoachSeats();
    static boolean[] nonAcCoachSeats = RailwayTicketBookingRepository.getNonAcCoachSeats();
    static boolean[] seaterCoachSeats = RailwayTicketBookingRepository.getSeaterSeats();
    public static int availableAcCoachSeatsCount(){
        return checkAvailableSeats(acCoachSeats);
    }

    public static int availableNonAcCoachSeatsCount(){
        return checkAvailableSeats(nonAcCoachSeats);
    }

    public static int availableSeaterCoachSeatsCount(){
        return checkAvailableSeats(seaterCoachSeats);
    }

    public static int checkAvailableSeats(boolean[] seats){
        int ans = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == false){
                ans++;
            }
        }
        return ans;
    }

    public static void checkTicketStatus(){
        int ticketID = UserInputOutputService.getTicketIdFromUser();
        Ticket ticket = allTickets.get(ticketID);
        if (ticket.isStatus()){
            DisplayService.displayBookingSuccessful();
            DisplayService.displayTicketDetails(ticket);
        }
        else{
            DisplayService.displayBookingWaiting();
        }
    }
}
