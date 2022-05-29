package service.impl;

import model.*;
import service.IOrderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    AccountServiceImpl accountService = new AccountServiceImpl();
//    OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();

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
//                orders.add(new Order(id, totalPrice, accountService.findById(accountId), status));
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
                orders.add(new Order());
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

    public void addToCart(CartItem cartItem, List<CartItem> list, int quantity) {
        for (CartItem c : list) {
            if (c.getProduct().getId() == cartItem.getProduct().getId()) {
                c.setQuantity(c.getQuantity() + quantity);
                c.setPrice(c.getPrice() + (cartItem.getProduct().getPrice() * quantity));
            } else {
                list.add(cartItem);
            }
        }
    }

    public double calTotalPrice(List<CartItem> list){
        double totalPrice = 0;
        for (CartItem c : list) {
            totalPrice += (c.getPrice() * c.getQuantity());
        }
        return totalPrice;
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
