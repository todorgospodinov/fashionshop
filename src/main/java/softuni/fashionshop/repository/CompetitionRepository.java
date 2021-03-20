package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Competition;
@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
