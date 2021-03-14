package softuni.fashionshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("SELECT SUM(i.price) FROM Item i")
    BigDecimal findTotalItemsSum();

   // List<Item > findAllByCategory_CategoryEnum(CategoryEnum categoryEnum);
}
