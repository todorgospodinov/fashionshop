package softuni.fashionshop.model.view;

import javax.persistence.Id;

public class BrandViewModel {
    private Long id;
    private String name;
    private String description;

    public BrandViewModel() {
    }
@Id
    public Long getId() {
        return id;
    }

    public BrandViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BrandViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
