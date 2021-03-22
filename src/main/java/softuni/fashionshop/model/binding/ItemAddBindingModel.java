package softuni.fashionshop.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


public class ItemAddBindingModel {
    private String name;
    private String description;
    private CategoryEnum categoryEnum;
    private LocalDate receivedOn;
    private String brand;
    private String imageUrl;
    private String videoUrl;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    public ItemAddBindingModel(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    @Size(min = 2, message = "Item name length must be more than two characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Enter valid category name!")
    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public ItemAddBindingModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @PastOrPresent(message = "Date cannot be in the future")
    public LocalDate getReceivedOn() {
        return receivedOn;
    }

    public ItemAddBindingModel setReceivedOn(LocalDate receivedOn) {
        this.receivedOn = receivedOn;
        return this;
    }



    @NotNull
    public String getBrand() {
        return brand;
    }

    public ItemAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @NotNull(message = "Enter valid image URL!")
    public String getImageUrl() {
        return imageUrl;
    }

    public ItemAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @NotNull(message = "Enter valid video URL!")
    public String getVideoUrl() {
        return videoUrl;
    }

    public ItemAddBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    @DecimalMin(value = "0", message = "Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemAddBindingModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryEnum=" + categoryEnum +
                ", receivedOn=" + receivedOn +
                ", brand='" + brand + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", price=" + price +
                '}';
    }
}

