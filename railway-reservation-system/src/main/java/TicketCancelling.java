import java.util.HashMap;

public class TicketCancelling extends TicketBooking{
    // Key: Seat Number, Value: Berth
    private static HashMap<Integer, Character> seatNumberWithBerth = new HashMap<>();
    private static int seatNumberTracker = 0;
    private static char preferenceTracker = '\0';

    public static void cancel(int id){
        if (findPassenger(id)){
            System.out.print("ID has been successfully removed");
        }
        else{
            System.out.print("Invalid ID is provided");
        }
    }
    public static boolean findPassenger(int id){
        for (Passenger confirmedPassenger :confirmedList){
            if (confirmedPassenger.getId() == id){
                //Step 1: Insert cancelled ticket in the hashmap
                seatNumberTracker = confirmedPassenger.getSeatNumber();
                preferenceTracker = confirmedPassenger.getPreferredBerth();
                seatNumberWithBerth.put(seatNumberTracker, preferenceTracker);
                //Step 2: Remove the cancelled ticket form all the list
                removeFromAll(confirmedPassenger);
                //Step 3: Move RAC ticket to berth
                addRacToConfirmed();
                //Step 4: Move wait ticket to RAC
                addWaitToRAC();
                return true;
            }
        }

        for (Passenger racPassenger :racList){
            if (racPassenger.getId() == id){
                racList.remove(racPassenger);
                return  true;
            }
        }

        for (Passenger waitingPassenger :waitingList){
            if (waitingPassenger.getId() == id){
                waitingList.remove(waitingPassenger);
                return true;
            }
        }

        return false;
    }

    public static void removeFromAll(Passenger toDeletePassenger){
        upperList.remove(toDeletePassenger);
        lowerList.remove(toDeletePassenger);
        middleList.remove(toDeletePassenger);
        confirmedList.remove(toDeletePassenger);
    }
    public static void addRacToConfirmed(){
        //Step 1: Get the first RAC passenger
        Passenger racPassenger = racList.poll();
        //Step 2: If there is a RAC passenger move him to the confirmed List
        if (racPassenger != null){
            //Step 3: Update the empty or required parameters in rac passengers
            racPassenger.setStatus("CONFIRMED");
            racPassenger.setSeatNumber(seatNumberTracker);
            racPassenger.setPreferredBerth(preferenceTracker);
            //Step 4: Add the passenger to the list based on the berth
            confirmedList.add(racPassenger);
            if (preferenceTracker == 'U'){
                upperList.add(racPassenger);
            }
            else if (preferenceTracker == 'M'){
                middleList.add(racPassenger);
            }
            else{
                lowerList.add(racPassenger);
            }
            //Step 5: Remove the Cancelled ticket from the hashmap since Cancelled ticket is occupied by the RAC ticket
            seatNumberWithBerth.remove(seatNumberTracker);
            //Step 6: Setting up the below to default values for next iterations
            seatNumberTracker = 0;
            preferenceTracker = '\0';
        }

    }
    public static void addWaitToRAC(){
        //Step 1: Get the first passenger from the waiting
        Passenger waitingPassenger = waitingList.poll();
        if (waitingPassenger != null){
            //Step 2: Put the waiting passenger to rac list
            waitingPassenger.setStatus("RAC");
            racList.add(waitingPassenger);
        }
    }
    //Getter Method for the Hashmap
    public static HashMap<Integer, Character> getSeatNumberWithBerth() {
        return seatNumberWithBerth;
    }
}
