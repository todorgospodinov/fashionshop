package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.Category;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();
    Category find(CategoryEnum categoryEnum);


}
