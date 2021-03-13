package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.service.CategoryService;
import softuni.fashionshop.service.ItemService;

@Controller
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ItemService itemService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
//        model.addAttribute("shirts", itemService.findAllItemsByCategoryEnum(CategoryEnum.SHIRT));
//        model.addAttribute("shoes", itemService.findAllItemsByCategoryEnum(CategoryEnum.SHOES));
//        model.addAttribute("suits", itemService.findAllItemsByCategoryEnum(CategoryEnum.SUIT));
//        model.addAttribute("totalSum", itemService.getTotalSum());
        return "all-items";
    }

}
