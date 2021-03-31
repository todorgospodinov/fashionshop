package softuni.fashionshop.model.view;

import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class ItemViewModel {
private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private String videoUrl;
    private Instant receivedOn;
    private CategoryEnum categoryEnum;
    private String brand;


    public ItemViewModel() {
    }

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

    public ItemViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ItemViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Instant getReceivedOn() {
        return receivedOn;
    }

    public ItemViewModel setReceivedOn(Instant receivedOn) {
        this.receivedOn = receivedOn;
        return this;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public ItemViewModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ItemViewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}