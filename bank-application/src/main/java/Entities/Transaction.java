package Entities;

public class Transaction {
    private TransactionStatus status;
    private int amount;
    private boolean redeem;

    public Transaction(TransactionStatus status) {
        this.status = status;
        this.redeem = true;
    }

    public Transaction(TransactionStatus status, int amount) {
        this.status = status;
        this.amount = amount;
        this.redeem = true;
    }

    public boolean isRedeem() {
        return redeem;
    }

    public void setRedeem(boolean redeem) {
        this.redeem = redeem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
