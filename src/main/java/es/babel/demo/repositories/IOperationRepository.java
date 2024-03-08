package es.babel.demo.repositories;

import es.babel.demo.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperationRepository extends JpaRepository<Operation, Long> {
}
