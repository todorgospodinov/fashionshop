package softuni.fashionshop.model.entity;

import io.micrometer.core.lang.NonNull;
import org.hibernate.validator.constraints.Length;
import softuni.fashionshop.model.entity.enums.BrandEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="brands")
public class Brand extends BaseEntity {
    private BrandEnum brandEnum;
    private List<Model> models = new ArrayList<>();

    public Brand() {
    }

    public Brand(BrandEnum brandEnum, List<Model> models) {
        this.brandEnum = brandEnum;
        this.models = models;
    }

    @Enumerated(EnumType.STRING)
    public BrandEnum getBrandEnum() {
        return brandEnum;
    }

    public Brand setBrandEnum(BrandEnum brandEnum) {
        this.brandEnum = brandEnum;
        return this;
    }

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Model> getModels() {
        return models;
    }

    public Brand setModels(List<Model> models) {
        this.models = models;
        return this;
    }


}

