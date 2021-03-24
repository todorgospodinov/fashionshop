package softuni.fashionshop.model.view;

import javax.persistence.Id;

public class CompetitionViewModel {
    private Long id;
    private String name;
    private String imgUrl;

    public CompetitionViewModel() {
    }
@Id
    public Long getId() {
        return id;
    }

    public CompetitionViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompetitionViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CompetitionViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
