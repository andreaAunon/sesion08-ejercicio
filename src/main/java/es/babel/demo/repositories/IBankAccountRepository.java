package es.babel.demo.repositories;

import es.babel.demo.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankAccountRepository extends JpaRepository<BankAccount, String> {

}
