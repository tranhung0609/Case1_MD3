package service.impl;

import model.Category;
import model.Promotion;
import service.IPromotionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionServiceImpl implements IPromotionService {
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
    public void add(Promotion promotion) throws SQLException {

    }

    @Override
    public Promotion findById(int id) {
        Promotion promotion = new Promotion();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM promotions WHERE id = ?")){
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                promotion = new Promotion(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotion;
    }

    @Override
    public List<Promotion> findAll() {
        List<Promotion> promotions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM promotions")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                promotions.add(new Promotion(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Promotion promotion) throws SQLException {
        return false;
    }
}
