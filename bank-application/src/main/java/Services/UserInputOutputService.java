package Services;

import java.util.Scanner;

public class UserInputOutputService {
    static Scanner sc = new Scanner(System.in);

    public static int fetchCustomerIDFromUser(){
        System.out.println("-----------------------------------------------");
        System.out.print("Enter your Customer ID: ");
        return sc.nextInt();
    }

    public static String fetchPasswordFromUser(){
        System.out.print("Enter your Password: ");
        return sc.next();
    }

    public static int fetchServiceRequiredFromUser(){
        System.out.println("|-------------------------------------------|");
        System.out.println("|------  Please choose your service --------|");
        System.out.println("|-------------------------------------------|");
        System.out.println("1. Display user details 💼\n" +
                "2. Create Gift Card 🪪\n" +
                "3. Top up gift card 💸\n" +
                "4. Get Transaction History of the gift card 💿\n" +
                "5. Block a gift card ❌\n" +
                "6. Logout from my account 🏃🏻\n" +
                "7. Purchase from gift card 💰\n" +
                "8. Redeem points 🎁");
        System.out.println("-----------------------------------------------");
        return sc.nextInt();
    }

    public static int fetchGiftCardNumberFromUser(){
        System.out.println("-----------------------------------------------");
        System.out.println("Enter gift card number: ");
        return sc.nextInt();
    }

    public static int fetchAmountToAddInGiftCardFromUser(){
        System.out.println("-----------------------------------------------");
        System.out.println("Enter the amount to be added in the gift card: ");
        return sc.nextInt();
    }

    public static int fetchProductPriceFromUser(){
        System.out.println("-----------------------------------------------");
        System.out.println("Enter the price of the product: ");
        return sc.nextInt();
    }

    public static int fetchCardPinFromUser(){
        System.out.println("-----------------------------------------------");
        System.out.println("Enter the pin: ");
        return sc.nextInt();
    }

    public static int fetchRedeemChoiceFromUser(){
        System.out.println("-----------------------------------------------");
        System.out.println("Do you want to redeem? \n1. Yes \n2. No");
        return sc.nextInt();
    }
}
