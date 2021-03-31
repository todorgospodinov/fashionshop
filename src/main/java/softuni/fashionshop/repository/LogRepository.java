package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.LogEntity;

import java.time.Instant;
import java.time.LocalDateTime;
@Repository
public interface LogRepository extends JpaRepository<LogEntity,Long> {
    void deleteByDateTimeBefore(Instant dateTime);
}
