package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.fashionshop.model.binding.ItemAddBindingModel;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.service.BrandService;
import softuni.fashionshop.service.ItemService;

import javax.validation.Valid;
import java.time.ZoneId;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, BrandService brandService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("itemAddBindingModel")
    public ItemAddBindingModel createAddBindingModel() {
        return new ItemAddBindingModel();
    }

    @GetMapping("/add")
    public String add(Model model) {
         model.addAttribute("brands",brandService.findAllBrands());

        return "add-item";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                                BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails principal) {
        if (bindingResult.hasErrors()) {
redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }


        ItemServiceModel itemServiceModel = modelMapper
                .map(itemAddBindingModel,ItemServiceModel.class);

      itemServiceModel.setUser(principal.getUsername());

        return "redirect:/home";
    }

// AlbumServiceModel albumServiceModel = modelMapper.map(
//        albumAddBindingModel,
//        AlbumServiceModel.class);
//
//    albumServiceModel.setUser(principal.getUsername());
//
//   albumServiceModel.setReleaseDate(albumAddBindingModel
//           .getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
////    albumService.createAlbum(albumServiceModel);
////    return "redirect:/home";
//  }

}