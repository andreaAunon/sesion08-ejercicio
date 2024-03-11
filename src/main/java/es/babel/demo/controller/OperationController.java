package es.babel.demo.controller;

import es.babel.demo.entities.Operation;
import es.babel.demo.services.interfaces.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operacion")
public class OperationController {

    private IOperationService operationsService;

    public OperationController(IOperationService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/add")
    public String addFondos(@RequestBody Operation operation){
        return this.operationsService.createOperation(operation);
    }

    @GetMapping("/transfer")
    public String tranfer(@RequestBody Operation operation){
        return this.operationsService.transfer(operation);
    }

    @GetMapping("/list/{iban}")
    public List<Operation> tranfer(@RequestParam String iban){
        return this.operationsService.getOperations(iban);
    }
}
