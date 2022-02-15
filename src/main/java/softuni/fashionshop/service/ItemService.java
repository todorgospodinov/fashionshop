package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.model.view.ItemViewModel;

import java.util.Collection;
import java.util.List;


public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);

    ItemViewModel findById(Long id);

    Item findEntityById(Long itemId);

    void delete(Long id);

    Collection<Item> getAllItems();


    //List<ItemViewModel> findAllItems ();


   // BigDecimal getTotalSum();

    //List<ItemViewModel> findAllItemsByCategoryEnum(CategoryEnum categoryEnum);



  //  void buyById(Long id);


}
