package Services;

import Controllers.GiftCardController;
import Entities.Customer;

public class UserCommand {

    public static void userCommandProcessor(Customer loggedInCustomer){
        boolean isLoggedIn = true;
        while(isLoggedIn){
            int userChoice = UserInputOutputService.fetchServiceRequiredFromUser();
            switch (userChoice){
                case 1: {
                    DisplayService.displayDetails(loggedInCustomer);
                    break;
                }
                case 2: {
                    GiftCardController.createGiftCard(loggedInCustomer);
                    break;
                }
                case 3: {
                    GiftCardController.topUpGiftCard(loggedInCustomer);
                    break;
                }
                case 4: {
                    GiftCardController.getTransactionHistory(loggedInCustomer);
                    break;
                }
                case 5: {
                    GiftCardController.blockGiftCard(loggedInCustomer);
                    break;
                }
                case 6: {
                    isLoggedIn = false;
                    break;
                }
                case 7: {
                    GiftCardController.purchaseFromGiftCard(loggedInCustomer);
                    break;
                }
                case 8: {
                    GiftCardController.redeemPoints(loggedInCustomer);
                    break;
                }
                default: {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
