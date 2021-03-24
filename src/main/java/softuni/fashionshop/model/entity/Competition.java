package softuni.fashionshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="competitions")
public class Competition extends BaseEntity{
    private String name;
    private String imgUrl;
    private UserEntity userEntity;

    public Competition() {
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Competition setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "img", nullable = false)
    public String getImgUrl() {
        return imgUrl;
    }

    public Competition setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Competition setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
