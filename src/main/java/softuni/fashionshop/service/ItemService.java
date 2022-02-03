package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.model.view.ItemViewModel;


public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);

    ItemViewModel findById(Long id);

    Item findEntityById(Long itemId);

    void delete(Long id);

    //List<ItemViewModel> findAllItems ();


   // BigDecimal getTotalSum();

    //List<ItemViewModel> findAllItemsByCategoryEnum(CategoryEnum categoryEnum);



  //  void buyById(Long id);


}
