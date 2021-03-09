package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.Category;
import softuni.fashionshop.model.entity.CategoryName;

public interface CategoryService {
    void initCategories();
    Category find(CategoryName categoryName);
}
