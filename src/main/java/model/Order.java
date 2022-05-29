package model;

public class Order {
    private int id;
    private double totalPrice;
    private Account account;
    private String status;

    public Order() {
    }

    public Order(int id, double totalPrice, Account account, String status) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.account = account;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
