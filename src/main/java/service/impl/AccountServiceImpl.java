package service.impl;

import model.Account;
import service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    List<Account> accountList;

    @Override
    public List<Account> findAll() {
        return accountList;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Account account) {

    }

    @Override
    public void remove(int id) {

    }
}
