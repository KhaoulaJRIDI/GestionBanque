package app.gestion.banque.repositories;

import app.gestion.banque.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation,Integer> {
    Optional<Validation> findByCode(String code);
}
