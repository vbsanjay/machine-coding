import java.util.*;

public class TicketBooking {
    private static int breathLimit = 6/3;
    private static int racLimit = 1;
    private static int waitingLimit = 1;
    private static int upperSeatNumber = 1;
    private static int middleSeatNumber = 2;
    private static int lowerSeatNumber = 3;
    static ArrayList<Passenger> upperList = new ArrayList<>();
    static ArrayList<Passenger> middleList = new ArrayList<>();
    static ArrayList<Passenger> lowerList = new ArrayList<>();
    static ArrayList<Passenger> confirmedList = new ArrayList<>();
    static Queue<Passenger> racList = new LinkedList<>();
    static Queue<Passenger> waitingList = new LinkedList<>();

    public static void bookTicket(Passenger passenger){
        if (upperList.size() == breathLimit && middleList.size() == breathLimit
                && lowerList.size() == breathLimit) {
            // Code executes only if all the tickets were booked
            if (checkRACLimit()) {
                // Code executes if RAC limit isn't reached
                System.out.println("RAC ticket has been allotted");
                passenger.setStatus("RAC");
                racList.add(passenger);
            } else if (checkWaitingLimit()) {
                // Code executes if Waiting List limit isn't reached
                System.out.println("Your ticket is in the waiting list");
                passenger.setStatus("WAITING");
                waitingList.add(passenger);
            } else {
                System.out.println("Ticket not available");
                allBookingStatus();
            }
        }
        else if (checkAvailability(passenger)){
            System.out.println("Your ticket has been booked");
            passenger.setStatus("CONFIRMED");
            confirmedList.add(passenger);
        }
        else {
            System.out.println("Ticket can't be booked ");
            allBookingStatus();
        }
    }

    public static boolean checkRACLimit(){
        if (racList.size() < racLimit){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkWaitingLimit(){
        if (waitingList.size() < waitingLimit){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkAvailability(Passenger passenger){
        HashMap<Integer, Character> map = TicketCancelling.getSeatNumberWithBerth();
        char passengerPreferredBerth = passenger.getPreferredBerth();
        if (passengerPreferredBerth == 'U'){
            if (upperList.size() < breathLimit){
                if (!map.isEmpty()){
                    updateSeatFromCancelled(map, passenger);
                }
                else{
                    passenger.setSeatNumber(upperSeatNumber);
                    upperSeatNumber += 3;
                }
                upperList.add(passenger);
                return true;
            }
        }
        else if (passengerPreferredBerth == 'M'){
            if (middleList.size() < breathLimit){
                if (!map.isEmpty()){
                    updateSeatFromCancelled(map, passenger);
                }
                else{
                    passenger.setSeatNumber(middleSeatNumber);
                    middleSeatNumber += 3;
                }
                middleList.add(passenger);
                return true;
            }
        }
        else{
            if (lowerList.size() < breathLimit){
                if (!map.isEmpty()){
                    updateSeatFromCancelled(map, passenger);
                }
                else{
                    passenger.setSeatNumber(lowerSeatNumber);
                    lowerSeatNumber += 3;
                }
                lowerList.add(passenger);
                return true;
            }
        }

        return false;
    }

    public static void allBookingStatus(){
        System.out.println("Upper berth available seats: " + (breathLimit - upperList.size()));
        System.out.println("Middle berth available seats: " + (breathLimit - middleList.size()));
        System.out.println("Lower berth available seats: " + (breathLimit - lowerList.size()));
    }

    public static void fetchConfirmedTicket(){
        for(Passenger confirmedPassenger: confirmedList){
            System.out.println(confirmedPassenger);
        }
    }
    public static void fetchRACTicket(){
        for(Passenger racPassenger: racList){
            System.out.println(racPassenger);
        }
    }
    public static void fetchWaitingTicket(){
        for(Passenger waitingPassenger: waitingList){
            System.out.print(waitingPassenger);
        }
    }

    public static void updateSeatFromCancelled(HashMap<Integer, Character> map, Passenger passenger){
        int tempSeatNumber = 0;
        char preference = passenger.getPreferredBerth();
        for(Map.Entry<Integer,Character> entry : map.entrySet())
        {
            if(preference == (char)entry.getValue())
            {
                tempSeatNumber = (int)entry.getKey();
                break;
            }
        }
        passenger.setSeatNumber(tempSeatNumber);
        map.remove(tempSeatNumber);
    }
}
