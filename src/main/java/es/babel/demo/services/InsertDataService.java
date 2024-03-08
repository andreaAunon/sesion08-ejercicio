package es.babel.demo.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertDataService {

    private BankAccountService bankAccountService;

    @Autowired
    public InsertDataService(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @PostConstruct
    public void init(){
        //BankAccount ba1 = new BankAccount("ES9701282343912621679499",6000);
        //BankAccount ba2 = new BankAccount("ES7901286755798465925733",4000);
        bankAccountService.createBankAccount("ES9701282343912621679499",6000);
        bankAccountService.createBankAccount("ES7901286755798465925733",4000);
    }
}
