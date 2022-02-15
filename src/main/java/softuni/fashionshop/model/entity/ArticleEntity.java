package softuni.fashionshop.model.entity;


import org.springframework.format.annotation.DateTimeFormat;
import softuni.fashionshop.model.entity.enums.StyleEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {

    private String title;
    private String imageUrl;
    private StyleEnum styleEnum;
    private String content;

    private Instant createdOn;
    private UserEntity userEntity;

    public ArticleEntity() {
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public ArticleEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public ArticleEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public StyleEnum getStyleEnum() {
        return styleEnum;
    }

    public ArticleEntity setStyleEnum(StyleEnum styleEnum) {
        this.styleEnum = styleEnum;
        return this;
    }

    @Column(nullable = false)
    @NotNull
    @Size(min=3,max=512)
    public String getContent() {
        return content;
    }

    public ArticleEntity setContent(String content) {
        this.content = content;
        return this;
    }
    @Column(nullable = false)
    @DateTimeFormat(pattern="dd-MMM-YYYY")
    public Instant getCreatedOn() {
        return createdOn;
    }

    public ArticleEntity setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public ArticleEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}