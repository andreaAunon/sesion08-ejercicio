package es.babel.demo.controller;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.services.interfaces.IBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class BankAccountController {

    private final IBankAccountService bankAccountService;

    @Autowired
    public BankAccountController(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/init")
    public String init(){
        this.bankAccountService.init();
        return "BD iniciada";
    }

    @GetMapping("/list")
    public List<BankAccount> getBankAccounts(){
        return this.bankAccountService.getBankAccounts();
    }

    @GetMapping("/add")
    public String addBankAccount(@RequestBody BankAccount bankAccount){
        return this.bankAccountService.createBankAccount(bankAccount);
    }
}
