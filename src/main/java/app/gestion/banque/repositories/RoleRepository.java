package app.gestion.banque.repositories;

import app.gestion.banque.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Role findByRole(String role);
}
