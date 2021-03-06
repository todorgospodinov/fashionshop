package softuni.fashionshop.service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.fashionshop.model.entity.ArticleEntity;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.view.ArticleViewModel;
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
}