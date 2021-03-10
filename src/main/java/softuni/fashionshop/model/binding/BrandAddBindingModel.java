package softuni.fashionshop.model.binding;

import org.hibernate.validator.constraints.Length;

public class BrandAddBindingModel {
    private String name;

    public BrandAddBindingModel() {
    }
    @Length(min=2,message = "Brand name length must be more than two characters")
    public String getName() {
        return name;
    }

    public BrandAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
}
