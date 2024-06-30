package Service;

import Model.Ticket;
import Repository.RailwayTicketBookingRepository;

import java.util.HashMap;
import java.util.Queue;

public class TicketCancellationService {
    static HashMap<Integer, Ticket> allTickets = RailwayTicketBookingRepository.getAllTickets();
    static boolean[] acCoachSeats = RailwayTicketBookingRepository.getAcCoachSeats();
    static boolean[] nonAcCoachSeats = RailwayTicketBookingRepository.getNonAcCoachSeats();
    static boolean[] seaterCoachSeats = RailwayTicketBookingRepository.getSeaterSeats();
    static Queue<Ticket> getAcCoachWL = RailwayTicketBookingRepository.getAcCoachWL();
    static Queue<Ticket> getNonAcCoachWL = RailwayTicketBookingRepository.getNonAcCoachWL();
    static Queue<Ticket> getSeaterCoachWL = RailwayTicketBookingRepository.getSeaterCoachWL();

    public static void cancelTicket(){
        int ticketID = UserInputOutputService.getTicketIdFromUser();
        updateStatus(allTickets.get(ticketID));
    }

    public static void updateStatus(Ticket ticket){
        if(ticket.getCoach().equals("AC_COACH")){
            replaceSeats(acCoachSeats, getAcCoachWL, ticket);
        }
        else if(ticket.getCoach().equals("NON_AC_COACH")){
            replaceSeats(nonAcCoachSeats, getNonAcCoachWL, ticket);
        }
        else{
            replaceSeats(seaterCoachSeats, getSeaterCoachWL, ticket);
        }
    }

    public static void replaceSeats(boolean[] seats, Queue<Ticket> waitingList, Ticket ticket){
        if(!waitingList.isEmpty()){
            Ticket waitingTicket = waitingList.poll();
            waitingTicket.setTicketId(ticket.getTicketId());
            waitingTicket.setSeatNumber(ticket.getSeatNumber());
            waitingTicket.setStatus(true);
            DisplayService.displayWlSeatConfirmed(waitingTicket);
        }
        else{
            seats[ticket.getSeatNumber() - 1] = false;
        }
        allTickets.remove(ticket.getTicketId());
    }
}
