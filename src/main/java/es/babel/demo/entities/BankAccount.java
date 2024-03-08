package es.babel.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="bankAccount")
public class BankAccount {

    @Id
    private String iban;

    private double fondos;

    public BankAccount(String iban, double fondos){
        super();
        this.iban = iban;
        this.fondos = fondos;
    }

    public String getIban(){
        return this.iban;
    }

    public double getFondos() {
        return fondos;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setFondos(double fondos) {
        this.fondos = fondos;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", fondos=" + fondos +
                '}';
    }
}
