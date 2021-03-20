package softuni.fashionshop.model.service;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;

public class CompetitionServiceModel {
    private Long id;
    private MultipartFile imageUrl;

    public CompetitionServiceModel() {
    }
@Id
    public Long getId() {
        return id;
    }

    public CompetitionServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public MultipartFile getImageUrl() {
        return imageUrl;
    }

    public CompetitionServiceModel setImageUrl(MultipartFile imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
