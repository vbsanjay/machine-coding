package Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer {
    private int id;
    private String name;
    private List<GiftCard> giftCardsList;
    private int accountBalance;
    private Set<GiftCard> blockedCardsList;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.accountBalance = 10000;
        this.giftCardsList = new ArrayList<>();
        this.blockedCardsList = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GiftCard> getGiftCardsList() {
        return giftCardsList;
    }

    public void setGiftCardsList(List<GiftCard> giftCardsList) {
        this.giftCardsList = giftCardsList;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<GiftCard> getBlockedCardsList() {
        return blockedCardsList;
    }

    public void setBlockedCardsList(Set<GiftCard> blockedCardsList) {
        this.blockedCardsList = blockedCardsList;
    }
}
