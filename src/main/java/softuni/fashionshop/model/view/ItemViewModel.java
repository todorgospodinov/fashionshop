package softuni.fashionshop.model.view;

import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemViewModel {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;
    private CategoryEnum categoryEnum;
    private Brand brand;


    public ItemViewModel() {
    }
@Id
    public Long getId() {
        return id;
    }

    public ItemViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public ItemViewModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public ItemViewModel setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}