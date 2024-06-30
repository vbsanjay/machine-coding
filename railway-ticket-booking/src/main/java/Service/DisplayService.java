package Service;

import Model.Ticket;
import Repository.RailwayTicketBookingRepository;

public class DisplayService {
    public static void displayAvailableService(){
        System.out.println("🛠 Please Choose a Service: 🛠");
        System.out.println();
        System.out.println("1. Ticket Booking");
        System.out.println("2. Ticket Cancellation");
        System.out.println("3. Status Checking");
        System.out.println("4. Prepare Chart");
        System.out.println("5. Exit");
    }

    public static void displayCoach(){
        System.out.println("Please choose a coach you need to book:");
        System.out.printf("%8s | %15s | %15s | %15s |\n", "Sl. No", "Coach", "Available Seats", " Waiting List");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%8d | %15s | %15d | %15d |\n", 1, "AC Coach", StatusCheckingService.availableAcCoachSeatsCount(), RailwayTicketBookingRepository.getAcCoachWL().size());
        System.out.printf("%8d | %15s | %15d | %15d |\n", 2, "Non-AC Coach", StatusCheckingService.availableNonAcCoachSeatsCount(), RailwayTicketBookingRepository.getNonAcCoachWL().size());
        System.out.printf("%8d | %15s | %15d | %15d |\n", 3, "Seater", StatusCheckingService.availableSeaterCoachSeatsCount(), RailwayTicketBookingRepository.getSeaterCoachWL().size());
    }

    public static void displayBookingFailed(){
        System.out.println("Ticket booking failed! ❌");
    }

    public static void displayBookingSuccessful(){
        System.out.println("Your booking is successful ✅");
    }

    public static void displayBookingWaiting(){
        System.out.println("Your booking is waiting ✋🏻");
    }

    public static void displayTicketDetails(Ticket ticket){
        System.out.println("Ticket Details: ");
        System.out.println("Name: " + ticket.getName());
        System.out.println("Ticket Number: " + ticket.getTicketId());
        System.out.println("Coach booked: " + ticket.getCoach());
        System.out.println("Seat Number: " + ticket.getSeatNumber());
        if(ticket.isStatus()){
            System.out.println("Ticket Status: " + "Confirmed");
        }
        else{
            System.out.println("Ticket Status: " + "Waiting");
        }
        System.out.println();
    }

    public static void displayCancelTicketID(){
        System.out.println("Enter the ticket number to be cancelled: ");
    }

    public static void displayEnterName(){
        System.out.println("Enter your name: ");
    }

    public static void displayWlSeatConfirmed(Ticket ticket){
        System.out.println("Waiting Seat is confirmed ✅");
        displayTicketDetails(ticket);
    }
}
