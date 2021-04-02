package softuni.fashionshop.service;

import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.view.ArticleViewModel;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void addArticle(ArticleServiceModel articleServiceModel);
    List<ArticleViewModel> findAllArticles();
    Optional<ArticleViewModel> findLatestArticle();

}
