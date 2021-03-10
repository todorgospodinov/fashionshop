package softuni.fashionshop.model.service;

import softuni.fashionshop.model.entity.enums.CategoryEnum;

public class CategoryServiceModel {
    private CategoryEnum categoryEnum;
    private String description;

    public CategoryServiceModel() {
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryName(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}