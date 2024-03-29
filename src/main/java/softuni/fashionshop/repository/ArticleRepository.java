package softuni.fashionshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuni.fashionshop.model.entity.ArticleEntity;
import softuni.fashionshop.model.view.ArticleViewModel;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
    Optional<ArticleEntity> findTopByOrderByCreatedOnDesc();

}
