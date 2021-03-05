package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
