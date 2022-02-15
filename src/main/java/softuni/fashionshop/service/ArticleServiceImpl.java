package softuni.fashionshop.service;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import softuni.fashionshop.exceptions.ArticleNotFoundException;
import softuni.fashionshop.model.entity.ArticleEntity;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.StyleEnum;
import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.view.ArticleViewModel;
import softuni.fashionshop.model.view.ItemViewModel;
import softuni.fashionshop.repository.ArticleRepository;
import softuni.fashionshop.repository.UserRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository,
                               UserRepository userRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addArticle(ArticleServiceModel articleServiceModel) {
        ArticleEntity articleEntity = this.modelMapper.map(articleServiceModel, ArticleEntity .class);
        articleEntity.setCreatedOn(Instant.now());

        UserEntity creator = userRepository.
                findByUsername(articleServiceModel.getUser()).
                orElseThrow(() -> new IllegalArgumentException("Creator "
                + articleServiceModel.getUser() + " could not be found"));
        articleEntity.setUserEntity(creator);

        this.articleRepository.saveAndFlush(articleEntity);
    }


    @Override
    public Collection<ArticleEntity> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public ArticleViewModel findById(Long id) {
        return this.articleRepository.findById(id)
                .map(article -> {
                    ArticleViewModel articleViewModel = this.modelMapper
                            .map(article,ArticleViewModel.class);


                    return articleViewModel;

                }).orElseThrow(IllegalArgumentException::new);

    }

//    @Override
//    public ArticleEntity getArticleById(Long id) throws ArticleNotFoundException {
//
//        Optional<ArticleEntity> result= articleRepository.findById(id);
//        if(result.isPresent()){
//            return result.get();
//        }
//        throw new ArticleNotFoundException("Not find any article with id " + id);
//
//    }
//
//    @Override
//    public ArticleEntity createOffer(ArticleEntity article) {
//        return null;
//    }

//    @Override
//    public ArticleEntity updateArticle(ArticleEntity articleEntity, Long id) {
//
//ArticleEntity existingArticle = articleRepository.findById(id).orElseThrow();
//
//existingArticle.setTitle(articleEntity.getTitle());
//        existingArticle.setImageUrl(articleEntity.getImageUrl());
//       // existingArticle.setStyleEnum(StyleEnum.valueOf());
//             existingArticle.setContent(articleEntity.getContent());
//articleRepository.save(existingArticle);
//        return existingArticle;
//    }

//    @Override
//    public String updateArticle(ArticleEntity articleEntity) {
//        boolean foundResource=false;
//        for(ArticleEntity current: articleRepository.findAll() ){
//            if(current.getId()==articleEntity.getId()) {
//                foundResource=true;
//                current.setTitle(articleEntity.getTitle());
//                current.setImageUrl(articleEntity.getImageUrl());
//                current.setContent(articleEntity.getContent());
//            }
//        }
//if( !foundResource){
//    articleRepository.save(articleEntity);
//    return "Success";
//}
//
//     return "Success";
//    }

//    @Override
//    public ArticleEntity deleteArticle(Long id) {
//        return null;
//    }



    @Override
    public List<ArticleViewModel> findAllArticles() {
        return articleRepository.
                findAll().
                stream().
                map(ae -> {
                    ArticleViewModel avm = modelMapper.map(ae, ArticleViewModel.class);
                    avm.setAuthor(ae.getUserEntity().getUsername());
                    return avm;
                }).
                collect(Collectors.toList());
    }



    @Override
    public Optional<ArticleViewModel> findLatestArticle() {
        return articleRepository.
                findTopByOrderByCreatedOnDesc().
                map(ae -> {
                    ArticleViewModel avm = modelMapper.map(ae, ArticleViewModel.class);
                    avm.setAuthor(ae.getUserEntity().getUsername());
                    return avm;
                });
    }

//    @Override
//    public ArticleServiceModel edit(ArticleServiceModel articleServiceModel, Long id) {
//        ArticleEntity articleFromObj=this.articleRepository
//                .findById(articleServiceModel.getId()).orElseThrow();
//
//        ArticleEntity updateArticle = this.articleRepository.saveAndFlush(articleFromObj);
//        return this.modelMapper.map(updateArticle,ArticleServiceModel.class);
//    }
//
//    @Override
//    public void updateArticle(ArticleViewModel articleViewModel, Long id) {
//        ArticleEntity articleEntity = this.modelMapper.map(articleViewModel, ArticleEntity.class);
//        this.articleRepository.saveAndFlush(articleEntity);
//    }

    @Override
    public Optional<ArticleEntity> updateArticleById(Long id) {
        return articleRepository.findById(id);
    }


    @Override
    public void delete(Long id) {
this.articleRepository.deleteById(id);
    }
}