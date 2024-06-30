package Repository;

import Model.Ticket;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RailwayTicketBookingRepository {
    private static HashMap<Integer, Ticket> allTickets;
    private static boolean[] acCoachSeats;
    private static boolean[] nonAcCoachSeats;
    private static boolean[] seaterSeats;
    static Queue<Ticket> acCoachWL;
    static Queue<Ticket> nonAcCoachWL;
    static Queue<Ticket> seaterCoachWL;
    public static void initializeRailwayTicketBookingApplication(){
        allTickets = new HashMap<>();
        acCoachSeats = new boolean[2];
        nonAcCoachSeats = new boolean[2];
        seaterSeats = new boolean[2];
        acCoachWL = new LinkedList<>();
        nonAcCoachWL = new LinkedList<>();
        seaterCoachWL = new LinkedList<>();
    }

    public static HashMap<Integer, Ticket> getAllTickets() {
        return allTickets;
    }

    public static void setAllTickets(HashMap<Integer, Ticket> allTickets) {
        RailwayTicketBookingRepository.allTickets = allTickets;
    }

    public static boolean[] getAcCoachSeats() {
        return acCoachSeats;
    }

    public static void setAcCoachSeats(boolean[] acCoachSeats) {
        RailwayTicketBookingRepository.acCoachSeats = acCoachSeats;
    }

    public static boolean[] getNonAcCoachSeats() {
        return nonAcCoachSeats;
    }

    public static void setNonAcCoachSeats(boolean[] nonAcCoachSeats) {
        RailwayTicketBookingRepository.nonAcCoachSeats = nonAcCoachSeats;
    }

    public static boolean[] getSeaterSeats() {
        return seaterSeats;
    }

    public static void setSeaterSeats(boolean[] seaterSeats) {
        RailwayTicketBookingRepository.seaterSeats = seaterSeats;
    }

    public static Queue<Ticket> getAcCoachWL() {
        return acCoachWL;
    }

    public static void setAcCoachWL(Queue<Ticket> acCoachWL) {
        RailwayTicketBookingRepository.acCoachWL = acCoachWL;
    }

    public static Queue<Ticket> getNonAcCoachWL() {
        return nonAcCoachWL;
    }

    public static void setNonAcCoachWL(Queue<Ticket> nonAcCoachWL) {
        RailwayTicketBookingRepository.nonAcCoachWL = nonAcCoachWL;
    }

    public static Queue<Ticket> getSeaterCoachWL() {
        return seaterCoachWL;
    }

    public static void setSeaterCoachWL(Queue<Ticket> seaterCoachWL) {
        RailwayTicketBookingRepository.seaterCoachWL = seaterCoachWL;
    }
}
