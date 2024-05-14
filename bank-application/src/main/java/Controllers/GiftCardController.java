package Controllers;

import Entities.Customer;
import Entities.GiftCard;
import Entities.Transaction;
import Services.GiftCardService;
import Services.UserInputOutputService;

import java.util.List;

public class GiftCardController {
    public static void createGiftCard(Customer customer) {
        GiftCardService.createGiftCard(customer);
    }

    public static void topUpGiftCard(Customer customer){
        GiftCardService.listAllCards(customer);
        int cardNumber = UserInputOutputService.fetchGiftCardNumberFromUser();
        GiftCard giftcard = GiftCardService.searchGiftCardInCustomer(cardNumber, customer);
        if(GiftCardService.checkIfValidCard(giftcard)){
            GiftCardService.updateBalanceForGiftCard(giftcard, customer);
        }

    }

    public static void getTransactionHistory(Customer customer){
        GiftCardService.listAllCards(customer);
        int cardNumber = UserInputOutputService.fetchGiftCardNumberFromUser();
        GiftCard giftcard = GiftCardService.searchGiftCardInCustomer(cardNumber, customer);
        if(GiftCardService.checkIfValidCard(giftcard)){
            List<Transaction> transactionList = giftcard.getTransactionList();
            GiftCardService.displayAllTransactions(transactionList);
        }
    }



    public static void blockGiftCard(Customer customer){
        GiftCardService.listAllCards(customer);
        int cardNumber = UserInputOutputService.fetchGiftCardNumberFromUser();
        GiftCard giftcard = GiftCardService.searchGiftCardInCustomer(cardNumber, customer);
        if(GiftCardService.checkIfValidCard(giftcard)){
            GiftCardService.addCardToBlockList(giftcard);
            GiftCardService.transferAmountToMainAccount(giftcard);
        }
    }

    public static void purchaseFromGiftCard(Customer customer){
        GiftCardService.listAllCards(customer);
        int cardNumber = UserInputOutputService.fetchGiftCardNumberFromUser();
        GiftCard giftcard = GiftCardService.searchGiftCardInCustomer(cardNumber, customer);
        if(GiftCardService.checkIfValidCard(giftcard)){
            int priceOfProduct = UserInputOutputService.fetchProductPriceFromUser();
            int pin = UserInputOutputService.fetchCardPinFromUser();
            if(AuthenticationController.validateCard(giftcard, pin)){
                GiftCardService.updateTheCardBalance(priceOfProduct, giftcard);
            }
            else{
                System.out.println("Enter the correct pin");
            }
        }
    }

    public static void redeemPoints(Customer customer){
        GiftCardService.listAllCards(customer);
        int customerAccountBalance = customer.getAccountBalance();
        int cardNumber = UserInputOutputService.fetchGiftCardNumberFromUser();
        GiftCard giftcard = GiftCardService.searchGiftCardInCustomer(cardNumber, customer);
        if(GiftCardService.checkIfValidCard(giftcard)) {
            int redeemAvailable = GiftCardService.displayMyRedeemPoints(giftcard);
            if(redeemAvailable >= 10){
                int redeemChoice = UserInputOutputService.fetchRedeemChoiceFromUser();
                if (redeemChoice == 1){
                    customer.setAccountBalance(customerAccountBalance + redeemAvailable);
                    giftcard.setRedeemPoints(0);
                }
            }
            else {
                System.out.println("Minimum 10 redeem points required. Available redeem: " + giftcard.getRedeemPoints());
            }
        }
    }

}
