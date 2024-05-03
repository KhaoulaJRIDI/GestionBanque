package app.gestion.banque.repositories;

import app.gestion.banque.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface OperationRepository extends JpaRepository<Operation,Long> {

    @Query("SELECT op FROM Operation op WHERE op.compte.codeCompte=:x")
    public Collection<Operation> getAccountOperations(@Param("x") String codeCompte);
}
