package app.gestion.banque.repositories;

import app.gestion.banque.entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteCourantRepository extends JpaRepository<CompteCourant,String> {
}
