package es.babel.demo.services;

import es.babel.demo.entities.BankAccount;

import java.util.List;

public interface IBankAccountService {

    List<String> getBankAccounts();
    void createBankAccount(String iban, double fondos);
}
