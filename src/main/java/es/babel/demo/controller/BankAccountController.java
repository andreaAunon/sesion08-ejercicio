package es.babel.demo.controller;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.services.interfaces.IBankAccountService;
import es.babel.demo.services.interfaces.IInsertDataService;
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
    private final IInsertDataService insertDataService;

    @Autowired
    public BankAccountController(IBankAccountService bankAccountService,
                                 IInsertDataService insertDataService) {
        this.bankAccountService = bankAccountService;
        this.insertDataService = insertDataService;
    }

    @GetMapping("/init")
    public String init(){
        insertDataService.init();
        return "BD iniciada";
    }

    @GetMapping("/list")
    public List<BankAccount> getBankAccounts(){
        return bankAccountService.getBankAccounts();
    }

    @GetMapping("/add")
    public String addBankAccount(@RequestBody BankAccount bankAccount){
        String resultado = bankAccountService.createBankAccount(bankAccount);
        return resultado;
    }
}
