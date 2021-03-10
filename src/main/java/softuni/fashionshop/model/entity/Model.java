package softuni.fashionshop.model.entity;

import com.sun.istack.NotNull;
import io.micrometer.core.lang.NonNull;
import org.hibernate.validator.constraints.Length;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.model.entity.enums.ModelEnum;

import javax.persistence.*;

@Entity
@Table(name="models")
public class Model extends BaseEntity {
    private ModelEnum modelEnum;
    private Brand brand;
    private CategoryEnum category;
    private String imageUrl;

    public Model() {
    }

    public Model(ModelEnum modelEnum, Brand brand, CategoryEnum category, String imageUrl) {
        this.modelEnum = modelEnum;
        this.brand = brand;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    @Enumerated(EnumType.STRING)
    public ModelEnum getModelEnum() {
        return modelEnum;
    }

    public Model setModelEnum(ModelEnum modelEnum) {
        this.modelEnum = modelEnum;
        return this;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
    @NonNull
    @NotNull
    public CategoryEnum getCategory() {
        return category;
    }

    public Model setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    @NonNull
    @Length(min = 8, max = 512)
    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


}
