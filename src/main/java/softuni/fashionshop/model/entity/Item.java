package softuni.fashionshop.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private Instant receivedOn;
    private String imageUrl;
    private String videoUrl;
    private CategoryEnum categoryEnum;
    private Brand brand;
    private UserEntity userEntity;


    public Item() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }


    @Column(name = "received_on", nullable = false)
    public Instant getReceivedOn() {
        return receivedOn;
    }

    public Item setReceivedOn(Instant receivedOn) {
        this.receivedOn = receivedOn;
        return this;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    @Column(name = "image_url", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public Item setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Column(name = "video_url", nullable = false)
    public String getVideoUrl() {
        return videoUrl;
    }

    public Item setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public Item setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    @ManyToOne
    //@OnDelete(action= OnDeleteAction.CASCADE)
    public Brand getBrand() {
        return brand;
    }

    public Item setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Item setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }


}
