package es.babel.demo.controller;

import es.babel.demo.entities.Operation;
import es.babel.demo.services.interfaces.IOperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import es.babel.demo.utils.Log;

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
        if (operation.getCuentaEmisor() == null || operation.getCuentaReceptor() == null) {
            Log.error("Intento de transferencia con cuentas no existentes");
            return "Error, alguna cuenta no existe";
        }

        return this.operationsService.transfer(operation);
    }

    @GetMapping("/list/{iban}")
    public List<Operation> tranfer(@RequestParam String iban){
        return this.operationsService.getOperations(iban);
    }
}
