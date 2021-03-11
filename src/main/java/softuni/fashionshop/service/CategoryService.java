package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.Category;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.model.view.ItemViewModel;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    void initCategories();
    Category find(CategoryEnum categoryEnum);
   // Collection<Category> getAllCategories();

    //List<ItemViewModel> findAllItemsByCategoryEnum(CategoryEnum categoryEnum);
}
