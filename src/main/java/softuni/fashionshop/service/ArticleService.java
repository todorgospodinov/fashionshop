package softuni.fashionshop.service;

import org.springframework.security.core.userdetails.UserDetails;
import softuni.fashionshop.exceptions.ArticleNotFoundException;
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

  //  ArticleEntity getArticleById(Long id) throws ArticleNotFoundException;
  //  ArticleEntity createOffer(ArticleEntity article);
//    ArticleEntity updateArticle(ArticleEntity articleEntity, Long id);
 //   ArticleEntity deleteArticle(Long id);

    List<ArticleViewModel> findAllArticles();

    Optional<ArticleViewModel> findLatestArticle();

 //  ArticleServiceModel edit(ArticleServiceModel articleServiceModel, Long id);

 // void updateArticle(ArticleViewModel articleViewModel, Long id);

  Optional<ArticleEntity> updateArticleById(Long id);

    void delete(Long id);
}
