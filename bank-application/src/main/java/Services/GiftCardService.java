package Services;

import Entities.Customer;
import Entities.GiftCard;
import Entities.Transaction;
import Entities.TransactionStatus;

import java.util.List;

public class GiftCardService {
    public static void listAllCards(Customer customer){
        System.out.println("List of all available cards: ");
        for(GiftCard giftCard:  customer.getGiftCardsList()){
            System.out.println(giftCard.getGiftCardNumber());
        }
    }
    public static void createGiftCard(Customer customer){
        GiftCard giftCard = new GiftCard(1234, customer);
        customer.getGiftCardsList().add(giftCard);
        System.out.println("Gift card has been created 🪪");
    }

    public static GiftCard searchGiftCardInCustomer(int cardNumber, Customer customer){
        List<GiftCard> giftCardsList = customer.getGiftCardsList();
        for(GiftCard giftCard: giftCardsList){
            if(giftCard.getGiftCardNumber() == cardNumber){
                return giftCard;
            }
        }
        return null;
    }
    public static void updateBalanceForGiftCard(GiftCard giftCard, Customer customer){
        int amountToAddInGiftCard = UserInputOutputService.fetchAmountToAddInGiftCardFromUser();
        int currentBalanceInCustomerAccount = customer.getAccountBalance();
        if(currentBalanceInCustomerAccount >= amountToAddInGiftCard){
            customer.setAccountBalance(currentBalanceInCustomerAccount - amountToAddInGiftCard);
            giftCard.setAmount(giftCard.getAmount() + amountToAddInGiftCard);
            giftCard.getTransactionList().add(new Transaction(TransactionStatus.RECEIVED, amountToAddInGiftCard));
            System.out.println("Top up is successful ✅\nGift card Balance 💸: " + giftCard.getAmount());
        }
        else{
            System.out.println("Insufficient fund ❌");
            System.out.println("Your account balance 💵: " + customer.getAccountBalance());
        }
    }

    public static void displayAllTransactions(List<Transaction> transactionList){
        for(int i = 0; i < transactionList.size(); i++){
            Transaction transaction = transactionList.get(i);
            if(transaction.getStatus() == TransactionStatus.RECEIVED){
                System.out.println("Money received form bank account  💸: " + transaction.getAmount());

            }else if(transaction.getStatus() == TransactionStatus.SENT){
                System.out.println("Money spent on a purchase  💸: " + transaction.getAmount());
            }

            System.out.println("-----------------------------------------------------------------");
        }

    }

    public static boolean checkIfValidCard(GiftCard giftCard){
        if(giftCard == null) {
            System.out.println("Invalid card number ❌");
            return false;
        }
        if(giftCard.getCustomer().getBlockedCardsList().contains(giftCard)){
            System.out.println("Card is blocked ❌");
            return false;
        }
        return true;
    }

    public static void addCardToBlockList(GiftCard giftCard){
        Customer cardOwner = giftCard.getCustomer();
        cardOwner.getBlockedCardsList().add(giftCard);
    }

    public static void transferAmountToMainAccount(GiftCard giftCard){
        Customer cardOwner = giftCard.getCustomer();
        cardOwner.setAccountBalance(giftCard.getAmount() + cardOwner.getAccountBalance());
    }
    public static void updateTheCardBalance(int priceOfProduct, GiftCard giftCard){
        int currentBalanceInGiftCard = giftCard.getAmount();
        if (currentBalanceInGiftCard >= priceOfProduct){
            giftCard.setAmount(currentBalanceInGiftCard - priceOfProduct);
            giftCard.getTransactionList().add(new Transaction(TransactionStatus.SENT, priceOfProduct));
            System.out.println("Purchase has been made 💸");
            System.out.println("Current Balance: " + giftCard.getAmount());
        }
        else{
            System.out.print("Insufficient balance please recharge ❌");
            System.out.print("Current Balance: " + giftCard.getAmount());
        }
    }

    public static boolean checkPasswordMatch(GiftCard giftCard, int pin){
        if(giftCard.getPin() == pin){
            return true;
        }
        else{
            return false;
        }
    }

    public static int displayMyRedeemPoints(GiftCard giftCard){
        giftCard.setRedeemPoints(calculateRedeemPoints(giftCard.getTransactionList()));
        System.out.println("My total Redeem Points: " + giftCard.getRedeemPoints());
        return giftCard.getRedeemPoints();
    }

    public static int calculateRedeemPoints(List<Transaction> transactionList){
        int totalSpent = 0;
        int redeemPoints = 0;
        for(Transaction transaction: transactionList){
            if(transaction.isRedeem() && transaction.getStatus() == TransactionStatus.SENT){
                totalSpent += transaction.getAmount();
                if(totalSpent >= 100){
                    redeemPoints = totalSpent / 100;
                    totalSpent = totalSpent % 100;
                }
                transaction.setRedeem(false);
            }
        }
        return redeemPoints;
    }
}
