package es.babel.demo.repositories;

import es.babel.demo.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByCuentaEmisor(String cuentaEmisor);

    List<Operation> findAllByCuentaReceptor(String cuentaReceptor);
}
