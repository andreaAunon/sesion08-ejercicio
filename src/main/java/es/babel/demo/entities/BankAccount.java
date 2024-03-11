package es.babel.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bankAccount")
public class BankAccount {

    @Id
    private String iban;

    @Column
    private String nombreUsuario;

    @Column
    private Double fondos;



    public BankAccount(){

    }

    public BankAccount(String iban, String nombreUsuario, Double fondos){
        super();
        this.iban = iban;
        this.fondos = fondos;
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", fondos=" + fondos +
                '}';
    }
}
