package app.gestion.banque.repositories;

import app.gestion.banque.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
