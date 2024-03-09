package es.babel.demo.services;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.repositories.IBankAccountRepository;
import es.babel.demo.services.interfaces.IBankAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService implements IBankAccountService {

    private IBankAccountRepository bankAccountRepository;

    public BankAccountService(IBankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public String createBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
        return "Cuenta añadida correctamente";
    }
}
