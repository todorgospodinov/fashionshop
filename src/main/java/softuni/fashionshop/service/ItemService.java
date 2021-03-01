package softuni.fashionshop.service;

import softuni.fashionshop.model.service.ItemServiceModel;

public interface ItemService {
    void addItem(ItemServiceModel map);

    Object findById(String id);

    void delete(String id);
}
