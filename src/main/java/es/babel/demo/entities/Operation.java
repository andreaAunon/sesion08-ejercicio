package es.babel.demo.entities;

import es.babel.demo.entities.enums.MovementEnum;
import jakarta.persistence.*;

@Entity
@Table(name="bankAccount")
public class Operation {

    @Id
    @GeneratedValue
    private Long idOperation;
    private Double cantidad;
    private MovementEnum movementType;

    @ManyToOne
    @JoinColumn(name="iban")
    private BankAccount bankAccount;

    public Operation(Long idOperation, Double cantidad, MovementEnum movementType){
        super();
        this.idOperation = idOperation;
        this.cantidad = cantidad;
        this.movementType = movementType;

    }

    public Long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Long idOperation) {
        this.idOperation = idOperation;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public MovementEnum getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementEnum movementType) {
        this.movementType = movementType;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "idOperation=" + idOperation +
                ", cantidad=" + cantidad +
                ", movementType=" + movementType +
                ", bankAccount=" + bankAccount +
                '}';
    }

}
