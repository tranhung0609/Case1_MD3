package service.impl;

import model.Category;
import model.Product;
import service.IProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    static String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce_case_md3?useSSL=false";
    static String jdbcUsername = "root";
    static String jdbcPassword = "123456";

    public static final String SELECT_ALL_PRODUCTS_AT_BUY = "SELECT * FROM products WHERE accountId <> ?"; // Join các bảng khác để lấy name các bảng
    public static final String SELECT_ALL_PRODUCTS_AT_SELL = "SELECT * FROM products WHERE accountId = ?";
    public static final String INSERT_PRODUCTS_SQL = "INSERT INTO customer(name, price, image, quantity, categoryId, promotionId, accountId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE id = ?;";
    public static final String UPDATE_PRODUCT_SQL = "UPDATE products SET name = ?, price = ?, image = ?, quantity = ?, categoryId = ?, promotionId = ?  WHERE id = ?;";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT products.id, products.name, price, image, quantity, quantitySold, c.name, p.name, a.name " +
            "FROM products JOIN accounts a ON a.id = products.accountId " +
            "JOIN categories c ON c.id = products.categoryId " +
            "JOIN promotions p ON p.id = products.promotionId;";

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
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setInt(6, product.getPromotionId());
            preparedStatement.setInt(7, AccountServiceImpl.currentAccount.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Product findById(int id) {
//        List<Product> products = findAll();
//        for (Product p : products) {
//            if (p.getId() == id) {
//                return p;
//            }
//        }
//        return null;
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                int quantity = rs.getInt("quantity");
                int quantitySold = rs.getInt("quantityId");
                int categoryId = rs.getInt("categoryId");
                int promotionId = rs.getInt("promotionId");
                int accountId = rs.getInt("accountId");
                product = new Product(id, name, price, image, quantity, quantitySold, categoryId, promotionId, accountId);
            }
        } catch (SQLException e) {
        }
        return product;
    }

    //lấy List category để hiển thị loại sản phẩm thay vì Id
    List<Category> findAllCategoryByProducts(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Category category = categoryService.findById(products.get(i).getCategoryId());
            categories.add(category);
        }
        return categories;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    public List<Product> findAllAtBuy() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_AT_BUY)
        )
        {
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
                int accountId =  AccountServiceImpl.currentAccount.getId();
                products.add(new Product(id, name, price, image, quantity, quantitySold, categoryId, promotionId, accountId));
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
        )
        {
            preparedStatement.setInt(1,  AccountServiceImpl.currentAccount.getId());
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
//                int accountId = rs.getInt("accountId");
                int accountId =  AccountServiceImpl.currentAccount.getId();
                products.add(new Product(id, name, price, image, quantity, quantitySold, categoryId, promotionId, accountId));
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
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setInt(6, product.getPromotionId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
