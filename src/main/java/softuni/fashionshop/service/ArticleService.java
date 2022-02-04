package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.ArticleEntity;
import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.view.ArticleViewModel;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void addArticle(ArticleServiceModel articleServiceModel);

    Collection<ArticleEntity> getArticles();
    ArticleViewModel findById(Long id);

    ArticleEntity getArticleById(Long id);
    ArticleEntity createOffer(ArticleEntity article);
    ArticleEntity updateArticle(ArticleEntity article);
    ArticleEntity deleteArticle(Long id);


    List<ArticleViewModel> findAllArticles();

    Optional<ArticleViewModel> findLatestArticle();

    void delete(Long id);
}
