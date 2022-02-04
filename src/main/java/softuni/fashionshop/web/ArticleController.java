package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
@Autowired
    public ArticleController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }

//
//    @GetMapping("/all")
//    public String getAllArticles( Model model) {
//
//        Optional<ArticleViewModel> articleOpt = articleService.findLatestArticle();
//        if (articleOpt.isPresent()) {
//            model.addAttribute("latestArticle", articleOpt.get());
//        }
//        return "all-articles";
//    }


        @GetMapping("/all")
        public String getArticles(Model articles) {
            Optional<ArticleViewModel> articleOpt = articleService.findLatestArticle();
        if (articleOpt.isPresent()) {
            articles.addAttribute("latestArticle", articleOpt.get());
        }

            articles.addAttribute("articles", articleService.getArticles()); // set model data
            return "all-articles";
        }



    @GetMapping("/add")
    public String addArticle() {
        return "add-article";
    }

    @ModelAttribute("articleAddBindingModel")
    public ArticleAddBindingModel createBindingModel() {
        return new ArticleAddBindingModel();
    }

    @PostMapping("/add")
    public String addArticle(@Valid ArticleAddBindingModel articleAddBindingModel,
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


    @GetMapping("/details")
    public ModelAndView getArticleDetails(@RequestParam("id") Long id, ModelAndView modelAndView) {
       modelAndView.addObject("article", this.articleService.findById(id));
       modelAndView.setViewName("details-article");
        return modelAndView;
    }

@GetMapping("/delete/{id}")
public String delete (@PathVariable("id") Long id){
this.articleService.delete(id);
return "redirect:/articles/all";
}

}
