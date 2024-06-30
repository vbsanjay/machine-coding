package Service;

import Model.Ticket;
import Repository.RailwayTicketBookingRepository;

import java.util.HashMap;
import java.util.Queue;

public class TicketBookingService {
    static HashMap<Integer, Ticket> allTickets = RailwayTicketBookingRepository.getAllTickets();
    static boolean[] acCoachSeats = RailwayTicketBookingRepository.getAcCoachSeats();
    static boolean[] nonAcCoachSeats = RailwayTicketBookingRepository.getNonAcCoachSeats();
    static boolean[] seaterCoachSeats = RailwayTicketBookingRepository.getSeaterSeats();
    static Queue<Ticket> getAcCoachWL = RailwayTicketBookingRepository.getAcCoachWL();
    static Queue<Ticket> getNonAcCoachWL = RailwayTicketBookingRepository.getNonAcCoachWL();
    static Queue<Ticket> getSeaterCoachWL = RailwayTicketBookingRepository.getSeaterCoachWL();
    public static void bookTicket(){
        int coachChoice = UserInputOutputService.getRequiredCoach();
        String name = UserInputOutputService.getUserName();
        switch (coachChoice){
            case 1:
                bookACCoach(name);
                break;
            case 2:
                bookNonAcCoach(name);
            case 3:
                bookSeaterCoach(name);
        }
    }

    public static void bookACCoach(String name){
        for(int i = 0; i < acCoachSeats.length; i++){
            if (acCoachSeats[i] == false){
                int id = Integer.parseInt("777" + i);
                Ticket newTicket = createTicket(id, name,i+1, true, "AC_COACH");
                allTickets.put(newTicket.getTicketId(), newTicket);
                acCoachSeats[i] = true;
                DisplayService.displayBookingSuccessful();
                DisplayService.displayTicketDetails(newTicket);
                return;
            }
        }
        if (getAcCoachWL.size() >= 3){
            DisplayService.displayBookingFailed();
        }
        else{
            int id = Integer.parseInt("777" + (getAcCoachWL.size() + 1));
            Ticket newTicket = createTicket(-id, name,-1, false, "AC_COACH");
            getAcCoachWL.offer(newTicket);
            allTickets.put(newTicket.getTicketId(), newTicket);
            DisplayService.displayBookingWaiting();
        }
    }

    public static void bookNonAcCoach(String name){
        for(int i = 0; i < nonAcCoachSeats.length; i++){
            if (nonAcCoachSeats[i] == false){
                int id = Integer.parseInt("888" + i);
                Ticket newTicket = createTicket(id, name, i+1, true, "NON_AC_COACH");
                allTickets.put(newTicket.getTicketId(), newTicket);
                nonAcCoachSeats[i] = true;
                DisplayService.displayBookingSuccessful();
                DisplayService.displayTicketDetails(newTicket);
                return;
            }
        }
        if (getNonAcCoachWL.size() >= 3){
            DisplayService.displayBookingFailed();
        }
        else{
            int id = Integer.parseInt("888" + (getNonAcCoachWL.size() + 1));
            Ticket newTicket = createTicket(-id, name, -1, false, "NON_AC_COACH");
            getNonAcCoachWL.offer(newTicket);
            allTickets.put(newTicket.getTicketId(), newTicket);
            DisplayService.displayBookingWaiting();
        }
    }

    public static void bookSeaterCoach(String name){
        for(int i = 0; i < seaterCoachSeats.length; i++){
            if (seaterCoachSeats[i] == false){
                int id = Integer.parseInt("999" + i);
                Ticket newTicket = createTicket(id, name,i+1, true, "SEATER_COACH");
                allTickets.put(newTicket.getTicketId(), newTicket);
                seaterCoachSeats[i] = true;
                DisplayService.displayBookingSuccessful();
                DisplayService.displayTicketDetails(newTicket);
                return;
            }
        }
        if (getSeaterCoachWL.size() >= 3){
            DisplayService.displayBookingFailed();
        }
        else{
            int id = Integer.parseInt("999" + (getSeaterCoachWL.size() + 1));
            Ticket newTicket = createTicket(-id, name,-1, false, "SEATER_COACH");
            allTickets.put(newTicket.getTicketId(), newTicket);
            getSeaterCoachWL.offer(newTicket);
            DisplayService.displayBookingWaiting();
        }
    }

    public static Ticket createTicket(int ticketId, String name, int seatNumber, boolean status, String coach){
        return new Ticket(ticketId, name, seatNumber, status, coach);
    }

}
