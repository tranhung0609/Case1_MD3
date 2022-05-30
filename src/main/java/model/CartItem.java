package model;

public class CartItem {
    private Product product;
    private Account account;
    private double price;
    private int quantity;

    public CartItem() {
    }

//    public CartItem(Product product, double price, int quantity) {
//        this.product = product;
//        this.price = price;
//        this.quantity = quantity;
//    }

    public CartItem(Product product, Account account, double price, int quantity) {
        this.product = product;
        this.account = account;
        this.price = price;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
