package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String image;
    private int quantity;
    private int quantitySold;
    private Category category;
    private Promotion promotion;
    private Account account;

    public Product() {
    }

    public Product(String name, double price, String image, int quantity, Category category, Promotion promotion, Account account) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.category = category;
        this.promotion = promotion;
        this.account = account;
    }

    public Product(int id, String name, double price, String image, int quantity, int quantitySold, Category category, Promotion promotion, Account account) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.quantitySold = quantitySold;
        this.category = category;
        this.promotion = promotion;
        this.account = account;
    }

    public Product(int id, String name, double price, String image, int quantity, Category category, Promotion promotion, Account account) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.category = category;
        this.promotion = promotion;
        this.account = account;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


