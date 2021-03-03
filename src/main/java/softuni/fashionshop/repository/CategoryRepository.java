package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Category;
import softuni.fashionshop.model.entity.CategoryName;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByCategoryName(CategoryName categoryName);

}
