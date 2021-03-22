package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.fashionshop.model.entity.LogEntity;

public interface LogRepository extends JpaRepository<LogEntity,Long> {
}
