package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {

}
