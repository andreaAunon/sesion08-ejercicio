package es.babel.demo.services.interfaces;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.entities.Operation;

import java.util.List;

public interface IOperationService {

    String createOperation(Operation operation);
    String transfer(Operation operation);
    List<Operation> getOperations(String iban);
}
