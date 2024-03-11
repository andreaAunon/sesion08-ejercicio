package es.babel.demo.entities;

import es.babel.demo.entities.enums.MovementEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bankAccount")
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double cantidad;
    @Column
    private MovementEnum tipoDeMovimiento;
    @Column
    private String cuentaReceptor;

    @ManyToOne
    @JoinColumn(name="iban")
    private BankAccount cuentaEmisor;

    public Operation(){

    }

    public Operation(Long id, Double cantidad, MovementEnum tipoDeMovimiento, BankAccount cuentaEmisor,
                     String cuentaReceptor){
        super();
        this.id = id;
        this.cantidad = cantidad;
        this.tipoDeMovimiento = tipoDeMovimiento;
        this.cuentaEmisor = cuentaEmisor;
        this.cuentaReceptor = cuentaReceptor;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", movementType=" + tipoDeMovimiento +
                ", cuentaReceptor='" + cuentaReceptor + '\'' +
                ", cuentaEmisor=" + cuentaEmisor +
                '}';
    }
}
