package softuni.fashionshop.model.service;
import javax.persistence.Id;
import java.math.BigDecimal;

public class ItemServiceModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String gender;
    private CategoryServiceModel category;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }
}
