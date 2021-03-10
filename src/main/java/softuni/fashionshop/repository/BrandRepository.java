package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.fashionshop.model.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
