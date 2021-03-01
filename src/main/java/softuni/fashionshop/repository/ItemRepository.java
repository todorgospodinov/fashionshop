package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
