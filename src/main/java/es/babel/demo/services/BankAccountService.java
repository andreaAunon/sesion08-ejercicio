package es.babel.demo.services;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.repositories.IBankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService implements IBankAccountService {

    private IBankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(IBankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public List<String> getBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        List<String> bankAccountsText = new ArrayList<>();

        for(BankAccount bankAccount : bankAccounts){
            bankAccountsText.add(bankAccount.toString());
        }

        return bankAccountsText;
    }

    @Override
    public void createBankAccount(String iban, double fondos) {
        BankAccount newBankAccount = new BankAccount(iban,fondos);
        newBankAccount.setIban(iban);
        newBankAccount.setFondos(fondos);

        bankAccountRepository.save(newBankAccount);
    }
}
