package softuni.fashionshop.model.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Expose
    private String name;
    @Expose
    private String description;

    public Brand() {
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Brand setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


