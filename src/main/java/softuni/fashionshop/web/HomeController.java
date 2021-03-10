package softuni.fashionshop.web;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.service.ItemService;

@Controller
public class HomeController {
private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index() {

    return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}