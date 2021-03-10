package softuni.fashionshop.model.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime receivedOn;
    private String gender;
    private Model model;
    private String imageUrl;
    private Category category;

    public Item() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "received_on", nullable = false)
    @PastOrPresent
    public LocalDateTime getReceivedOn() {
        return receivedOn;
    }

    public Item setReceivedOn(LocalDateTime receivedOn) {
        this.receivedOn = receivedOn;
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public Item setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @ManyToOne
    public Model getModel() {
        return model;
    }

    public Item setModel(Model model) {
        this.model = model;
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

    @ManyToOne
    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
