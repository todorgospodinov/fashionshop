package softuni.fashionshop.model.entity;

import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
private CategoryEnum categoryEnum;
private String description;

    public Category() {
    }

    public Category(CategoryEnum categoryEnum, String description) {
        this.categoryEnum = categoryEnum;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
@Column(name="description",columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
