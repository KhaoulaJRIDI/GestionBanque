package app.gestion.banque.repositories;

import app.gestion.banque.entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEpargneRepository extends JpaRepository<CompteEpargne,String> {
}
