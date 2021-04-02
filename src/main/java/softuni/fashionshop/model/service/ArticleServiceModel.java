package softuni.fashionshop.model.service;

import softuni.fashionshop.model.entity.enums.StyleEnum;

public class ArticleServiceModel {

    private String title;
    private String imageUrl;
    private StyleEnum styleEnum;
    private String content;
    private String user;

    public ArticleServiceModel() {
    }


    public String getTitle() {
        return title;
    }

    public ArticleServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ArticleServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public StyleEnum getStyleEnum() {
        return styleEnum;
    }

    public ArticleServiceModel setStyleEnum(StyleEnum styleEnum) {
        this.styleEnum = styleEnum;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ArticleServiceModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ArticleServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "ArticleServiceModel{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", styleEnum=" + styleEnum +
                ", content='" + content + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
