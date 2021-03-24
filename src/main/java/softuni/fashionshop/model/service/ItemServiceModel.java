package softuni.fashionshop.model.service;

import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class ItemServiceModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Instant receivedOn;
    private String imageUrl;
    private String videoUrl;
    private CategoryEnum categoryEnum;
    private String brand;
    private String user;

    public ItemServiceModel() {
    }

    @Id
    public Long getId() {
        return id;
    }

    public ItemServiceModel setId(Long id) {
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

    public Instant getReceivedOn() {
        return receivedOn;
    }

    public ItemServiceModel setReceivedOn(Instant receivedOn) {
        this.receivedOn = receivedOn;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ItemServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ItemServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public ItemServiceModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ItemServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ItemServiceModel setUser(String user) {
        this.user = user;
        return this;
    }
}