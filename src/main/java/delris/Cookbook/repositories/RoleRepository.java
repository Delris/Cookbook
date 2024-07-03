package delris.Cookbook.repositories;

import delris.Cookbook.entities.Role;
import delris.Cookbook.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
