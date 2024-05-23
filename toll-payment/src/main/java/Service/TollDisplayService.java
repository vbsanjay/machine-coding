package Service;

import Entity.Bill;
import Entity.Toll;
import Repository.TollPaymentApplicationRepository;

import java.util.List;

public class TollDisplayService {
    public static void displayAllTollDetails(){
        List<Toll> totalTolls = TollPaymentApplicationRepository.getTolls();
        for(Toll toll: totalTolls){
            System.out.println("------------------ Details of Toll: " + toll.getTollNumber() +" ------------------");
            System.out.printf("%5s %15s %15s %15s%n", "sl.no", "vehicle Number", "vehicle Type", "amount Paid");
            System.out.println("--------------------------------------------------------");
            List<Bill> bills = toll.getBills();
            int totalAmountCollected = 0;
            for(int i = 0; i < bills.size(); i++){
                Bill currentBill = bills.get(i);
                System.out.printf("%5s %15s %15s %15s%n", i+1, currentBill.getVehicle().getRegistrationNumber(), currentBill.getVehicle().getVehicleType(), currentBill.getBillAmount());
                totalAmountCollected += currentBill.getBillAmount();
            }
            System.out.println("TOTAL AMOUNT COLLECTED IN THE TOLL: " + totalAmountCollected);

            System.out.println();
        }
    }
}
