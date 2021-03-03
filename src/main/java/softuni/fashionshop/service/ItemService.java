package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.CategoryName;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.model.view.ItemViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems ();

    ItemViewModel findById(Long id);

    BigDecimal getTotalSum();

//    List<ItemViewModel> findAllItemsByCategoryName(CategoryName categoryName);

    void delete(Long id);


    void buyById(Long id);

}
