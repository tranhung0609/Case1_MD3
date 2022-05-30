package service.impl;

import model.*;
import service.IOrderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    AccountServiceImpl accountService = new AccountServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();
    ManageCartItem manageCartItem = new ManageCartItem();

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(ProductServiceImpl.jdbcURL, ProductServiceImpl.jdbcUsername, ProductServiceImpl.jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Order order) throws SQLException {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders(totalPrice, accountId, status) VALUES (?, ?, ?)")) {
//            double totalPrice = orderDetailService.calTotalPriceById(order.getId());
//            preparedStatement.setDouble(1, totalPrice);
//            preparedStatement.setInt(2, AccountServiceImpl.currentAccount.getId());
//            preparedStatement.setString(3, order.getStatus());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM orders")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double totalPrice = rs.getDouble("totalPrice");
                int accountId = rs.getInt("accountId");
                String status = rs.getString("status");
                orders.add(new Order(id, totalPrice, accountService.findById(accountId), status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findAllAtBuy() {
        List<Order> orders = new ArrayList<>();
//        List<OrderDetail> orderDetails = orderDetailService.;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM orders WHERE accountId = ?")) {
            preparedStatement.setInt(1, AccountServiceImpl.currentAccount.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double totalPrice = rs.getDouble("totalPrice");
                int accountId = rs.getInt("accountId");
                String status = rs.getString("status");
                orders.add(new Order(id, totalPrice, accountService.findById(accountId), status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findAllAtSell() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM orders WHERE accountId <> ?")) {
            preparedStatement.setInt(1, AccountServiceImpl.currentAccount.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double totalPrice = rs.getDouble("totalPrice");
                int accountId = rs.getInt("accountId");
                String status = rs.getString("status");
                orders.add(new Order(id, totalPrice, accountService.findById(accountId), status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    public double calTotalPrice(List<CartItem> list) {
        double totalPrice = 0;
        for (CartItem c : list) {
            totalPrice += (c.getProduct().getPrice() * c.getQuantity());
        }
        return totalPrice;
    }

    public boolean buy(int accountId, List<CartItem> list) throws SQLException {
        boolean rowBuy = true;
        List<CartItem> myCartItems = manageCartItem.findByAccount(accountId, list);
        for (CartItem c : myCartItems) {
            if (myCartItems.size() != 0) {
                Product product = productService.findById(c.getProduct().getId());
                if (product.getQuantity() >= c.getQuantity()) {
                    product.setQuantity(product.getQuantity() - c.getQuantity());
                    product.setQuantitySold(product.getQuantitySold() + c.getQuantity());
                    productService.updateAtBuy(product.getQuantity(), product.getQuantitySold(), c.getProduct().getId());
//                    productService.updateAtBuy((product.getQuantity() - c.getQuantity()), (product.getQuantitySold() + c.getQuantity()), c.getProduct().getId());
                    list.remove(c);
                } else {
                    rowBuy = false;
                }
            }
        }
        return rowBuy;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        return false;
    }

}
