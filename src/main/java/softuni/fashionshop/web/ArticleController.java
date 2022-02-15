package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.fashionshop.exceptions.ArticleNotFoundException;
import softuni.fashionshop.model.binding.ArticleAddBindingModel;
import softuni.fashionshop.model.binding.ItemAddBindingModel;
import softuni.fashionshop.model.entity.ArticleEntity;
import softuni.fashionshop.model.entity.enums.StyleEnum;
import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.view.ArticleViewModel;
import softuni.fashionshop.service.ArticleService;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
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

//    @ModelAttribute("article")
//    public ArticleAddBindingModel createArticleBindingModel() {
//        return new ArticleAddBindingModel();
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
       modelAndView.addObject("articleAddBindingModel", this.articleService.findById(id));
       modelAndView.setViewName("details-article");
        return modelAndView;
    }


    @GetMapping("/update/{id}")
    public String updateArticle(@PathVariable Long id, Model model) {
Optional<ArticleEntity> article = articleService.updateArticleById(id);
if(article.isPresent()){
    model.addAttribute("articleAddBindingModel",article.get());
    return "update-article";
}else {
    return "error-404";
}
    }

@PostMapping("/update/{id}")
public String confirmUpdateArticle(@PathVariable Long id, ModelMapper modelMapper,ArticleAddBindingModel articleAddBindingModel,
                                                                      @AuthenticationPrincipal UserDetails principal) {

    ArticleServiceModel articleServiceModel = modelMapper
            .map(articleAddBindingModel, ArticleServiceModel.class);

    articleServiceModel.setUser(principal.getUsername());


    articleService.addArticle(articleServiceModel);

        return "redirect:/articles/all";
}

//    @GetMapping("/update/{id}")
//    public ModelAndView getUpdateArticle(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("update-article");
//        modelAndView.addObject("styles", StyleEnum.values());
//        modelAndView.addObject("articleAddBindingModel", new ArticleViewModel());
//        return modelAndView;
//    }
//
//    @PostMapping("/update/{id}")
//    public ModelAndView confirmUpdate(@PathVariable("id") Long id, ArticleViewModel articleViewModel) {
//        this.articleService.updateArticle(articleViewModel,id);
//     //    return redirect("/articles/all");
//     //   return new ModelAndView( "redirect:/all-articles.html");
//        return new ModelAndView( "all-articles");
//    }





//@GetMapping("/update/{id}")
//public String updateArticle(Model model,@PathVariable("id") Long id){
//    model.addAttribute("article",this.articleService.findById(id));
//
//    return "update-article";
//}
//

//@PatchMapping("/update/{id}")
//public String updateConfirm (@PathVariable("id") Long id, @ModelAttribute("articleAddBindingModel") ArticleAddBindingModel articleAddBindingModel,@AuthenticationPrincipal UserDetails principal){
//    ArticleServiceModel articleServiceModel = modelMapper
//            .map(articleAddBindingModel, ArticleServiceModel.class);
//    articleServiceModel.setUser(principal.getUsername());
//
//    articleService.addArticle(articleServiceModel);
//
//    return "redirect:/articles/all";
//}

//@PutMapping({"{id}"})
//    public ResponseEntity <ArticleEntity> updateArticle(@PathVariable("id") Long id,
//@RequestBody ArticleEntity articleEntity){
//return new ResponseEntity<ArticleEntity>(articleService.updateArticle(articleEntity,id),HttpStatus.OK);
//    }


//    @GetMapping("/update/{id}")
//    public ModelAndView updateArticle(
//            @PathVariable Long id,
//            ModelAndView modelAndView,
//            @ModelAttribute("articleAddBindingModel") ArticleAddBindingModel articleAddBindingModel, Principal principal){
//
//
//    modelAndView.addObject("articleAddBindingModel",this.articleService.findById(id));
//        modelAndView.setViewName("update-article");
//        return modelAndView;
//    }
//
//    @PostMapping("/update/{id}")
//    public ModelAndView updateConfirm (
//            @PathVariable("id") Long id,
//                                       @ModelAttribute("articleAddBindingModel") ArticleAddBindingModel articleAddBindingModel,
//                                       ModelAndView modelAndView,
//            Principal principal)throws IOException {
//        ArticleServiceModel articleServiceModel = this.modelMapper
//                .map(articleAddBindingModel, ArticleServiceModel.class);
//        articleServiceModel.setUser(principal.getName());
//       this.articleService.edit(articleServiceModel, id);
//modelAndView.addObject("articleAddBindingModel",this.articleService.findById(id));
//
//        return modelAndView;
//    }


//@GetMapping("/update/{id}")
//public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
//try {
//    ArticleEntity updateArticle = articleService.getArticleById(id);
//    model.addAttribute("articleAddBindingModel", updateArticle);
//    return "update-article";
//} catch(ArticleNotFoundException e) {
//    ra.addFlashAttribute("message", "The article has been saved successfully");
//  return "redirect:/articles/all";
//    }
//}


    @GetMapping("/delete/{id}")
public String delete (@PathVariable("id") Long id){
this.articleService.delete(id);
return "redirect:/articles/all";
}

}
