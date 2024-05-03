package app.gestion.banque.repositories;

import app.gestion.banque.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

        public Fournisseur findFournisseurByName(String name);
}
