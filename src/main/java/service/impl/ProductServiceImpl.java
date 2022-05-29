package service.impl;

import model.Category;
import model.Product;
import service.IProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    PromotionServiceImpl promotionService = new PromotionServiceImpl();
    AccountServiceImpl accountService = new AccountServiceImpl();

    static String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce_case_md3?useSSL=false";
    static String jdbcUsername = "root";
    static String jdbcPassword = "1234";

    public static final String SELECT_ALL_PRODUCTS_AT_BUY = "SELECT * FROM products WHERE accountId <> ?";
    public static final String SELECT_ALL_PRODUCTS_AT_SELL = "SELECT * FROM products WHERE accountId = ?";
    public static final String INSERT_PRODUCTS_SQL = "INSERT INTO products(name, price, image, quantity, categoryId, promotionId, accountId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE id = ?;";
    public static final String UPDATE_PRODUCT_SQL = "UPDATE products SET name = ?, price = ?, image = ?, quantity = ?, categoryId = ?, promotionId = ?  WHERE id = ?;";

    public ProductServiceImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setInt(6, product.getPromotion().getId());
            preparedStatement.setInt(7, AccountServiceImpl.currentAccount.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Product findById(int id) {
        List<Product> products = findAll();
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Product> findByName(String name) {
        List<Product> products = findAllAtBuy();
        List<Product> listByName = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().contains(name)) {
                listByName.add(p);
            }
        }
        return listByName;
    }

    //lấy List category để hiển thị loại sản phẩm thay vì Id
    List<Category> findAllCategoryByProducts(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Category category = categoryService.findById(products.get(i).getCategory().getId());
            categories.add(category);
        }
        return categories;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products")
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                int quantity = rs.getInt("quantity");
                int quantitySold = rs.getInt("quantitySold");
                int categoryId = rs.getInt("categoryId");
                int promotionId = rs.getInt("promotionId");
                int accountId = rs.getInt("accountId");
                products.add(new Product(id, name, price, image, quantity, quantitySold, categoryService.findById(categoryId), promotionService.findById(promotionId), accountService.findById(accountId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> findAllAtBuy() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_AT_BUY)
        ) {
            preparedStatement.setInt(1, AccountServiceImpl.currentAccount.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                int quantity = rs.getInt("quantity");
                int quantitySold = rs.getInt("quantitySold");
                int categoryId = rs.getInt("categoryId");
                int promotionId = rs.getInt("promotionId");
                int accountId = rs.getInt("accountId");
//                int accountId = AccountServiceImpl.currentAccount.getId();
                products.add(new Product(id, name, price, image, quantity, quantitySold, categoryService.findById(categoryId), promotionService.findById(promotionId), accountService.findById(accountId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> findAllAtSell() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_AT_SELL)
        ) {
            preparedStatement.setInt(1, AccountServiceImpl.currentAccount.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                int quantity = rs.getInt("quantity");
                int quantitySold = rs.getInt("quantitySold");
                int categoryId = rs.getInt("categoryId");
                int promotionId = rs.getInt("promotionId");
                int accountId = AccountServiceImpl.currentAccount.getId();
                products.add(new Product(id, name, price, image, quantity, quantitySold, categoryService.findById(categoryId), promotionService.findById(promotionId), accountService.findById(accountId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdate = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setInt(6, product.getPromotion().getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
