package softuni.fashionshop.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private CategoryEnum category;
    private LocalDateTime receivedOn;
    private String imageUrl;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }
    @Length(min=2,message = "Item name length must be more than two characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Length(min=3,message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull(message="Enter valid category name!")
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "Date cannot be in the future")
    public LocalDateTime getReceivedOn() {
        return receivedOn;
    }

    public ItemAddBindingModel setReceivedOn(LocalDateTime receivedOn) {
        this.receivedOn = receivedOn;
        return this;
    }
    @NotNull(message="Enter valid image URL!")
    public String getImageUrl() {
        return imageUrl;
    }

    public ItemAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @DecimalMin(value="0", message="Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

