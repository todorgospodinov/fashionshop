package softuni.fashionshop.web;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.fashionshop.model.entity.enums.CategoryEnum;

import softuni.fashionshop.service.CarouselService;
import softuni.fashionshop.service.ItemService;

@Controller
public class HomeController {
private final ItemService itemService;
    private final CarouselService carouselService;

    public HomeController(ItemService itemService,CarouselService carouselService ) {
        this.itemService = itemService;
        this.carouselService = carouselService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("firstImg", carouselService.firstImage());
        model.addAttribute("secondImg", carouselService.secondImage());
        model.addAttribute("thirdImg", carouselService.thirdImage());
    return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}