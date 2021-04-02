package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.fashionshop.model.binding.ArticleAddBindingModel;
import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.view.ArticleViewModel;
import softuni.fashionshop.service.ArticleService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    public ArticleController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/all")
    public String getAllArticles( Model model) {

        Optional<ArticleViewModel> articleOpt = articleService.findLatestArticle();
        if (articleOpt.isPresent()) {
            model.addAttribute("latestArticle", articleOpt.get());
        }

        return "all-articles";
    }

    @GetMapping("/add")
    public String addArticle() {
        return "add-article";
    }

    @ModelAttribute("articleAddBindingModel")
    public ArticleAddBindingModel createAddBindingModel() {
        return new ArticleAddBindingModel();
    }


    @PostMapping("/add")
    public String addConfirm(@Valid ArticleAddBindingModel articleAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("articleAddBindingModel", articleAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.articleAddBindingModel", bindingResult);
            return "redirect:/articles/add";
        }

        ArticleServiceModel articleServiceModel = modelMapper
                .map(articleAddBindingModel, ArticleServiceModel.class);

       articleServiceModel.setUser(principal.getUsername());


        articleService.addArticle(articleServiceModel);
        return "redirect:/articles/all";
    }

}