package softuni.fashionshop.model.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BrandServiceModel {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime agreedOn;

    public BrandServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public BrandServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BrandServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getAgreedOn() {
        return agreedOn;
    }

    public BrandServiceModel setAgreedOn(LocalDateTime agreedOn) {
        this.agreedOn = agreedOn;
        return this;
    }
}
