import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        System.out.println("---------------------------------------");
        System.out.println("RAILWAY RESERVATION SYSTEM");
        boolean loop = true;

        while(loop){
            System.out.println("---------------------------------------");
            System.out.println("Choose the activity to be done: ");
            System.out.println("1. Book a ticket \n" +
                    "2. Cancel a ticket \n" +
                    "3. Fetch all confirmed ticket \n" +
                    "4. Fetch all RAC ticket \n" +
                    "5. Fetch all waiting List ticket \n" +
                    "6. Exit" );
            System.out.println("---------------------------------------");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            switch (num){
                case 1: {
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter your preferred berth");
                    String berth_temp = sc.next();
                    char berth = berth_temp.charAt(0);
                    if (berth == 'U' || berth == 'M' || berth == 'L' || berth == 'u' || berth == 'l' || berth == 'm'){
                        TicketBooking.bookTicket(new Passenger(name, berth));
                    }
                    else{
                        System.out.println("Provide valid berth");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the id to be cancelled");
                    int id = sc.nextInt();
                    TicketCancelling.cancel(id);
                    break;
                }
                case 3: {
                    TicketBooking.fetchConfirmedTicket();
                    break;
                }
                case 4: {
                    TicketBooking.fetchRACTicket();
                    break;
                }
                case 5: {
                    TicketBooking.fetchWaitingTicket();
                    break;
                }
                case 6: {
                    loop = false;
                    break;
                }
            }
        }

    }
}
