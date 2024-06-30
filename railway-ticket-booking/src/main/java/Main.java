import Controller.RailwaysTicketBookingController;
import Repository.RailwayTicketBookingRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚂 Welcome to railway ticket booking 🚂");
        initialSetup();
        RailwaysTicketBookingController.startRailwayTicketBookingApplication();
    }
    public static void initialSetup(){
        RailwayTicketBookingRepository.initializeRailwayTicketBookingApplication();
    }
}