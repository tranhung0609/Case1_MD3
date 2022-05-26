package service;

import model.Account;
import model.Product;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    void save(Account account);

    Account findById(int id);

    void update(int id, Account account);

    void remove(int id);

}
