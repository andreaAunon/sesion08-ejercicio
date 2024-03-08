package es.babel.demo.controller;

import es.babel.demo.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacion")
public class OperationController {

    private final IOperationService operationsService;

    @Autowired
    public OperationController(IOperationService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/add")
    public void addFondos(){

    }
}
