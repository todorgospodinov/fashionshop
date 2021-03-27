package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.fashionshop.model.entity.LogEntity;

import java.time.Instant;
import java.time.LocalDateTime;

public interface LogRepository extends JpaRepository<LogEntity,Long> {
    void deleteByDateTimeBefore(Instant dateTime);
}
