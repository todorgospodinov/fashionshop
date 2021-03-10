package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.fashionshop.model.binding.ItemAddBindingModel;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.service.ItemService;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("itemAddBindingModel")) {
            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());
       }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("itemAddBindingModel")
                                     ItemAddBindingModel itemAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:add";
        }
        this.itemService.addItem(this.modelMapper.map(itemAddBindingModel, ItemServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/all")
    public String allItems(Model model) {
        model.addAttribute("shirt",itemService.findAllItemsByCategoryEnum(CategoryEnum.SHIRT));
        model.addAttribute("shoes",itemService.findAllItemsByCategoryEnum(CategoryEnum.SHOES));
        model.addAttribute("suit",itemService.findAllItemsByCategoryEnum(CategoryEnum.SUIT));

        return "all-item";
    }


    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable Long id){
        itemService.buyById(id);
        return "redirect:/";
    }


    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") Long id, ModelAndView modelAndView) {
        modelAndView.addObject("item", this.itemService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id")Long id) {
        this.itemService.delete(id);
        return "redirect:/";
    }
}