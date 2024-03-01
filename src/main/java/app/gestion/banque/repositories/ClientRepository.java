package app.gestion.banque.repositories;

import app.gestion.banque.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {

   public Page<Client> findByNomClientContains(String nomClient, Pageable pageable);
}
