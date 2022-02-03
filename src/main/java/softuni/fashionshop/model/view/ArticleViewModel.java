package softuni.fashionshop.model.view;


import softuni.fashionshop.model.entity.enums.StyleEnum;

public class ArticleViewModel {


    private Long id;
    private String title;
    private String imageUrl;
    private StyleEnum styleEnum;
    private String content;
    private String author;


    public Long getId() {
        return id;
    }

    public ArticleViewModel setId(Long id) {
        this.id = id;
        return this;
    }


    public String getTitle() {
        return title;
    }

    public ArticleViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ArticleViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public StyleEnum getStyleEnum() {
        return styleEnum;
    }

    public ArticleViewModel setStyleEnum(StyleEnum styleEnum) {
        this.styleEnum = styleEnum;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ArticleViewModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ArticleViewModel setAuthor(String author) {
        this.author = author;
        return this;
    }
}
