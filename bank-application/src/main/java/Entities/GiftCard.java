package Entities;

import java.util.ArrayList;
import java.util.List;

public class GiftCard {
    private static int giftCardNumberProvider = 10000;
    private int giftCardNumber;
    private int pin;
    private int amount;
    private List<Transaction> transactionList;
    private Customer customer;
    private int redeemPoints;
    public GiftCard(int pin, Customer customer) {
        this.giftCardNumber = giftCardNumberProvider++;
        this.pin = pin;
        this.amount = 0;
        transactionList = new ArrayList<>();
        this.customer = customer;
    }

    public static int getGiftCardNumberProvider() {
        return giftCardNumberProvider;
    }

    public static void setGiftCardNumberProvider(int giftCardNumberProvider) {
        GiftCard.giftCardNumberProvider = giftCardNumberProvider;
    }

    public int getGiftCardNumber() {
        return giftCardNumber;
    }

    public void setGiftCardNumber(int giftCardNumber) {
        this.giftCardNumber = giftCardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRedeemPoints() {
        return redeemPoints;
    }

    public void setRedeemPoints(int redeemPoints) {
        this.redeemPoints = redeemPoints;
    }
}
