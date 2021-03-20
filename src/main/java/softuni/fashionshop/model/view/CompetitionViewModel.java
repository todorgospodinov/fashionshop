package softuni.fashionshop.model.view;

import javax.persistence.Id;

public class CompetitionViewModel {
    private Long id;
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public CompetitionViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
