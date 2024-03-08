package es.babel.demo.controller;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.services.IBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class BankAccountController {

    private final IBankAccountService bankModificationService;

    @Autowired
    public BankAccountController(IBankAccountService bankModificationService) {
        this.bankModificationService = bankModificationService;
    }

    @GetMapping("/list")
    public List<String> getBankAccounts(){
        return bankModificationService.getBankAccounts();
    }

    @GetMapping("/add")
    public void addBankAccount(){

    }
}
