package Controllers;

import Entities.GiftCard;
import Services.AuthenticationService;
import Services.GiftCardService;

public class AuthenticationController {
    private static int LoggedInCustomerID;
    public static boolean login(){
        LoggedInCustomerID = AuthenticationService.fetchCustomerID();
        String enteredPassword = AuthenticationService.fetchPassword();
        return AuthenticationService.validateLogin(LoggedInCustomerID, enteredPassword);
    }

    public static boolean validateCard(GiftCard giftCard, int pin){
        return GiftCardService.checkPasswordMatch(giftCard, pin);
    }

    public static int getLoggedInCustomerID() {
        return LoggedInCustomerID;
    }

    public static void setLoggedInCustomerID(int loggedInCustomerID) {
        LoggedInCustomerID = loggedInCustomerID;
    }
}
