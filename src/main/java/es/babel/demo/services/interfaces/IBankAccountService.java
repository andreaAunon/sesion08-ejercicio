package es.babel.demo.services.interfaces;

import es.babel.demo.entities.BankAccount;

import java.util.List;

public interface IBankAccountService {

    void init();
    List<BankAccount> getBankAccounts();
    String createBankAccount(BankAccount bankAccount);
    BankAccount findAccount(String iban);
}
