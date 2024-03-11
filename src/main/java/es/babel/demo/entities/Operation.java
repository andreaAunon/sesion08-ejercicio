package es.babel.demo.entities;

import es.babel.demo.entities.enums.MovementEnum;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="bankAccount")
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    private Double cantidad;
    private MovementEnum movementType;

    private String cuentaReceptor;

    @ManyToOne
    @JoinColumn(name="iban")
    private BankAccount cuentaEmisor;

    public Operation(){

    }

    public Operation(Long id, Double cantidad, MovementEnum movementType, BankAccount cuentaEmisor,
                     String cuentaReceptor){
        super();
        this.id = id;
        this.cantidad = cantidad;
        this.movementType = movementType;
        this.cuentaEmisor = cuentaEmisor;
        this.cuentaReceptor = cuentaReceptor;
    }

    public Long getIdOperation() {
        return id;
    }

    public void setIdOperation(Long idOperation) {
        this.id = idOperation;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidad() {
        return this.cantidad;
    }

    public MovementEnum getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementEnum movementType) {
        this.movementType = movementType;
    }

    public BankAccount getCuentaEmisor() {
        return cuentaEmisor;
    }

    public void setCuentaEmisor(BankAccount cuentaEmisor) {
        this.cuentaEmisor = cuentaEmisor;
    }

    public String getCuentaReceptor() {
        return cuentaReceptor;
    }

    public void setCuentaReceptor(String cuentaReceptor) {
        this.cuentaReceptor = cuentaReceptor;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", movementType=" + movementType +
                ", cuentaReceptor='" + cuentaReceptor + '\'' +
                ", cuentaEmisor=" + cuentaEmisor +
                '}';
    }
}
