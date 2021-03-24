package softuni.fashionshop.model.service;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import javax.validation.constraints.Email;

public class CompetitionServiceModel {
    private Long id;
    private String name;
    private MultipartFile img;


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

    public MultipartFile getImg() {
        return img;
    }

    public CompetitionServiceModel setImg(MultipartFile img) {
        this.img = img;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompetitionServiceModel setName(String name) {
        this.name = name;
        return this;
    }
}
