package service.impl;

import model.Account;
import service.IAccountService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    public static Account currentAccount;
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(ProductServiceImpl.jdbcURL, ProductServiceImpl.jdbcUsername, ProductServiceImpl.jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Account account) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO accounts(name, email, address, password) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getAddress());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM accounts WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("address");
                account = new Account(id, name, email, address, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM accounts")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                accounts.add(new Account(id, name, email, address, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }


    @Override
    public boolean delete(int id) throws SQLException {
//        boolean rowDeleted = false;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement("DELETE FROM accounts WHERE id = ?;")) {
//            preparedStatement.setInt(1, id);
//            rowDeleted = preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowDeleted;
        return false;
        // không xóa tài khoản
    }

    @Override
    public boolean update(Account account) throws SQLException {
        boolean rowUpdate = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE accounts SET name = ?, email = ?, address = ?, password = ? WHERE id = ?;")) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getEmail ());
            preparedStatement.setString(3, account.getAddress());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setInt(5, AccountServiceImpl.currentAccount.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    public boolean checkSignUp(Account account) throws SQLException {
        boolean check = true;
        List<Account> accounts = findAll();
        for (Account a : accounts) {
            if (a.getEmail().equals(account.getEmail())) {
                check = false;
                break;
            }
        }
        return check;
    }

    public boolean checkLogin(String email, String password) {
        boolean check = false;
        List<Account> accounts = findAll();
        for (Account a : accounts) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                check = true;
                currentAccount = a;
                break;
            }
        }
        return check;
    }

    public boolean checkPass(String password, String comfirmPass) {
        boolean check = false;
            if (password.equals(comfirmPass)) {
                check = true;
            }
        return check;
    }
}
