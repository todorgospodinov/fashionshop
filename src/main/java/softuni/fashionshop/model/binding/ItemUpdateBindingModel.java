package softuni.fashionshop.model.binding;

import softuni.fashionshop.model.entity.enums.CategoryEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemUpdateBindingModel {

    private String name;
    private String description;
    private String imageUrl;
    private String videoUrl;
    private BigDecimal price;

    public ItemUpdateBindingModel() {
    }



    @Size(min = 2, message = "Item name length must be more than two characters")
    public String getName() {
        return name;
    }

    public ItemUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @Size(min = 3, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public ItemUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
    @NotNull(message = "Enter valid image URL!")
    public String getImageUrl() {
        return imageUrl;
    }

    public ItemUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @NotNull(message = "Enter valid video URL!")
    public String getVideoUrl() {
        return videoUrl;
    }

    public ItemUpdateBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
    @DecimalMin(value = "0", message = "Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public ItemUpdateBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "ItemUpdateBindingModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
