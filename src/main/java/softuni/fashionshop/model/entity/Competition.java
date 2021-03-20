package softuni.fashionshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="competitions")
public class Competition extends BaseEntity{
    private String imageUrl;

    public Competition() {
    }
    @Column(name = "image_url", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public Competition setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
