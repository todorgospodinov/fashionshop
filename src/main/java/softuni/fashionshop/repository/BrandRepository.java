package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Brand;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT b.name FROM Brand b")
    List<String> findAllBrandsNames();

    Optional<Brand> findByName(String name);
}
