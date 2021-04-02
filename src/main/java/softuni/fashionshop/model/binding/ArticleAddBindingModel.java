package softuni.fashionshop.model.binding;

import softuni.fashionshop.model.entity.enums.StyleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArticleAddBindingModel {
    private String title;
    private String imageUrl;
    private StyleEnum styleEnum;
    private String content;


    public ArticleAddBindingModel() {
    }
    @Size(min = 2, message = "Title length must be more than two characters")
    public String getTitle() {
        return title;
    }

    public ArticleAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }
    @NotNull(message = "Enter valid image URL!")
    public String getImageUrl() {
        return imageUrl;
    }

    public ArticleAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @NotNull(message = "Enter valid style name!")
    public StyleEnum getStyleEnum() {
        return styleEnum;
    }

    public ArticleAddBindingModel setStyleEnum(StyleEnum styleEnum) {
        this.styleEnum = styleEnum;
        return this;
    }
    @Size(min = 3, message = "Content length must be more than three characters")
    public String getContent() {
        return content;
    }

    public ArticleAddBindingModel setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "ArticleAddBindingModel{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", styleEnum=" + styleEnum +
                ", content='" + content + '\'' +
                '}';
    }
}
