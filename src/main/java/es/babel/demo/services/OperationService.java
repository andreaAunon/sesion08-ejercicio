package es.babel.demo.services;

import es.babel.demo.entities.BankAccount;
import es.babel.demo.entities.Operation;
import es.babel.demo.entities.enums.MovementEnum;
import es.babel.demo.repositories.IBankAccountRepository;
import es.babel.demo.repositories.IOperationRepository;
import es.babel.demo.services.interfaces.IBankAccountService;
import es.babel.demo.services.interfaces.IOperationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationService implements IOperationService {

    private IOperationRepository operationRepository;
    private IBankAccountService bankAccountService;

    public OperationService(IOperationRepository operationRepository,
                            IBankAccountService bankAccountService){
        this.operationRepository = operationRepository;
        this.bankAccountService = bankAccountService;
    }

    @Override
    public String createOperation(Operation operation) {
        this.operationRepository.save(operation);
        return "Operacion correctamente";
    }

    @Override
    public String transfer(Operation operation) {
        // Primero se revisa que la cuenta a donde se realiza la operación existe
        if(this.bankAccountService.findAccount(operation.getCuentaReceptor()) != null){
            // Ahora se mira que la cuenta receptora sea de la misma compañia
            if(!operation.getCuentaEmisor().getIban().trim().substring(4, 8)
                    .equals(operation.getCuentaReceptor().trim().substring(4, 8))){
                addIntereses(operation);
            }

            addSaldo(operation);
            return "Transferencia completada";
        } else {
            return "No existe la cuenta destino";
        }
    }

    @Override
    public List<Operation> getOperations(String iban) {
        List<Operation> operations = new ArrayList<>();

        List<Operation> cuentaDeEmisor = this.operationRepository.findAllByCuentaEmisor(iban);
        for(Operation operation : cuentaDeEmisor){
            operations.add(operation);
        }

        List<Operation> cuentaDeReceptor = this.operationRepository.findAllByCuentaReceptor(iban);
        for(Operation operation : cuentaDeReceptor){
            operations.add(operation);
        }

        return operations;
    }

    private void addSaldo(Operation operation){
        BankAccount cuentaEmisor = operation.getCuentaEmisor();
        cuentaEmisor.setFondos(cuentaEmisor.getFondos() - operation.getCantidad());

        BankAccount cuentaReceptor = this.bankAccountService.findAccount(operation.getCuentaReceptor());
        cuentaReceptor.setFondos(cuentaReceptor.getFondos() + operation.getCantidad());
    }

    private void addIntereses(Operation operation){
        // No tiene cuenta receptora, es en banco
        Operation opWithIntereses = new Operation();

        opWithIntereses.setCuentaEmisor(operation.getCuentaEmisor());
        opWithIntereses.setCantidad(3.99);
        opWithIntereses.setMovementType(MovementEnum.SUB);

        createOperation(opWithIntereses);
    }
}
