package model;

import java.util.List;

public class Order {
    private int id;
    private List<OrderDetail> orderDetails;
    private Account account;
    private String status;

    public Order() {
    }

    public Order(int id, List<OrderDetail> orderDetails, Account account, String status) {
        this.id = id;
        this.orderDetails = orderDetails;
        this.account = account;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
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
