package service.impl;

import model.Order;
import model.OrderDetail;
import model.Product;
import service.IOrderDetailService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailServiceImpl implements IOrderDetailService {
//    OrderServiceImpl orderService = new OrderServiceImpl();
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
    public void add(OrderDetail orderDetail) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderdetails(orderId, productId, quantity) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, orderDetail.getOrder().getId());
            preparedStatement.setInt(2, orderDetail.getProduct().getId());
            preparedStatement.setInt(3, orderDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public OrderDetail findById(int id) {
        return null;
    }

    @Override
    public List<OrderDetail> findAll() {
        List<OrderDetail> orderDetails = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement("SELECT * FROM orderdetails")) {
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int orderId = rs.getInt("orderId");
//                int productId = rs.getInt("productId");
//                int quantity = rs.getInt("quantity");
//                orderDetails.add(new OrderDetail(orderService.findById(orderId), productService.findById(productId), quantity));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return orderDetails;
    }

    public double calTotalPriceById(int id) {
        double totalPrice = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM orderdetails WHERE orderId = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantity");
                Product product = productService.findById(productId);
                totalPrice = product.getPrice() * quantity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws SQLException {

        return false;
    }
}
