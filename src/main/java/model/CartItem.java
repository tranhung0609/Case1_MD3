package model;

public class CartItem {
    public static int cartItemId;
    private Product product;
    private Account account;
    private double price;
    private int quantity;

    public CartItem() {
    }


    public CartItem(Product product, Account account, double price, int quantity) {
        cartItemId ++;
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

    public double getPriceByPrm() {

        return price;
    }

    public static int getCartItemId() {
        return cartItemId;
    }

    public static void setCartItemId(int cartItemId) {
        CartItem.cartItemId = cartItemId;
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
