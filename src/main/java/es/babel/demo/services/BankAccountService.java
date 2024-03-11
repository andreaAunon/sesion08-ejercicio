package es.babel.demo.services;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.repositories.IBankAccountRepository;
import es.babel.demo.services.interfaces.IBankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService implements IBankAccountService {

    private IBankAccountRepository bankAccountRepository;

    public BankAccountService(IBankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void init(){
        BankAccount ba1 = new BankAccount("ES9701282343912621679499",6000.0);
        BankAccount ba2 = new BankAccount("ES7901286755798465925733",4000.0);

        createBankAccount(ba1);
        createBankAccount(ba2);
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return this.bankAccountRepository.findAll();
    }

    @Override
    public String createBankAccount(BankAccount bankAccount) {
        this.bankAccountRepository.save(bankAccount);
        return "Cuenta añadida correctamente";
    }

    @Override
    public BankAccount findAccount(String iban) {
        return this.bankAccountRepository.findBankAccountByIban(iban);
    }
}
