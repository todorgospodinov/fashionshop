package softuni.fashionshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.fashionshop.model.binding.ArticleAddBindingModel;
import softuni.fashionshop.model.binding.ItemAddBindingModel;
import softuni.fashionshop.model.binding.ItemUpdateBindingModel;
import softuni.fashionshop.model.entity.ArticleEntity;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.model.service.ArticleServiceModel;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.model.view.ItemViewModel;
import softuni.fashionshop.service.BrandService;
import softuni.fashionshop.service.ItemService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.ZoneId;
import java.util.Optional;

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
// Instant to  LocalDateTime
      itemServiceModel.setReceivedOn(itemAddBindingModel.getReceivedOn()
              .atStartOfDay(ZoneId.systemDefault()).toInstant());

      itemService.addItem(itemServiceModel);
        return "redirect:/items/all";
    }

    @GetMapping("/all")
    public String getAllItems(Model items){
        items.addAttribute("items", itemService.getAllItems()); // set model data
         return "all-items";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){

        ItemViewModel itemViewModel = itemService.findById(id);

        model.addAttribute("item", itemViewModel);

        return "details-item";
    }


//    @GetMapping("/update/{id}")
//    public String update (@PathVariable Long id , Model model){
//ItemServiceModel itemServiceModel = itemService.findItemById(id);
//        ItemAddBindingModel itemAddBindingModel = modelMapper.map(itemServiceModel, ItemAddBindingModel.class);
//        model.addAttribute("itemAddBindingModel", itemAddBindingModel);
//
////        if (!model.containsAttribute("itemAddBindingModel")) {
////                        ItemAddBindingModel itemAddBindingModel = modelMapper.map(itemServiceModel, ItemAddBindingModel.class);
//////                        itemUpdateBindingModel. (itemServiceModel. ().getBrand().getName() + " "
//////                                + itemServiceModel.getModel().getName());
////                        model.addAttribute("itemAddBindingModel", itemAddBindingModel);
////                    }
//
//
//            return "update-item";
//    }


    // @GetMapping("/{id}/update")
    //    public String getUpdatePage(@PathVariable Long id, Model model) {
    //        OfferServiceModel offerServiceModel = offerService.findOfferById(id);
    //        if (!model.containsAttribute("offerUpdateBindModel")) {
    //            OfferUpdateBindModel offerUpdateBindModel = modelMapper.map(offerServiceModel, OfferUpdateBindModel.class);
    //            offerUpdateBindModel.setModel(offerServiceModel.getModel().getBrand().getName() + " "
    //                    + offerServiceModel.getModel().getName());
    //            model.addAttribute("offerUpdateBindModel", offerUpdateBindModel);
    //        }
    //        return "update";
    //    }


    @GetMapping("/update/{id}")
    public String getUpdateItem(@PathVariable Long id, Model model ) {
        ItemServiceModel itemServiceModel = itemService.findItemById(id);

        model.addAttribute("itemAddBindingModel",itemServiceModel);
        model.addAttribute("brands",brandService.findAllBrands());
        return "update-item";
    }


//
//@GetMapping("/update/{id}")
//    public String update (@PathVariable Long id, Model model){
//Optional<Item> item = itemService.updateItem(id);
//    model.addAttribute("brands",brandService.findAllBrands());
//           if(item.isPresent()){
//
//           model.addAttribute("itemAddBindingModel",item.get());
//
//            return "update-item";
//        }else {
//            return "error-404";
//        }
//
//    }



    @PostMapping("/update/{id}")
    public String confirmUpdateItem(@PathVariable Long id, @AuthenticationPrincipal UserDetails principal,ItemAddBindingModel itemAddBindingModel){

        ItemServiceModel itemServiceModel = modelMapper
                .map(itemAddBindingModel,ItemServiceModel.class);

        itemServiceModel.setUser(principal.getUsername());
        itemServiceModel.setReceivedOn(itemAddBindingModel.getReceivedOn()
                .atStartOfDay(ZoneId.systemDefault()).toInstant());
        //itemServiceModel.setBrand(itemServiceModel.getBrand());
        itemService.addItem(itemServiceModel);

       // return "redirect:/items/all";
        return "all-items";

    }

//    @GetMapping("/update/{id}")
//    public ModelAndView getUpdateItem(@PathVariable Long id , ModelAndView modelAndView, ItemAddBindingModel itemAddBindingModel) {
//
//        ItemServiceModel itemServiceModel = itemService.findItemById(id);
//       itemAddBindingModel = this.modelMapper.map(itemServiceModel, ItemAddBindingModel.class);
//        modelAndView.addObject("itemAddBindingModel", itemServiceModel);
//        modelAndView.addObject("categoryEnum", CategoryEnum.values());
//        modelAndView.addObject("brands",brandService.findAllBrands());
//        modelAndView.setViewName("update-item");
//        return modelAndView;
//    }
//



//    @GetMapping("/update/{id}")
//    public ModelAndView update (@PathVariable Long id, ModelAndView modelAndView, @ModelAttribute("itemAddBindingModel") ItemAddBindingModel itemAddBindingModel){
//ItemServiceModel itemServiceModel = itemService.findItemById(id);
//        itemAddBindingModel = this.modelMapper.map(itemServiceModel, ItemAddBindingModel.class);
//       modelAndView.setViewName("update-item");
//        modelAndView.addObject("itemAddBindingModel", itemAddBindingModel);
//
//            return modelAndView;
//
//
//    }


//@GetMapping("/post/edit/{id}")
//    @PreAuthorize("isAuthenticated()")
//    public ModelAndView editPost(@PathVariable("id") String id, Principal principal, ModelAndView modelAndView, @ModelAttribute("bindingModel") PostEditBindingModel bindingModel) {
//        PostServiceModel postServiceModel = this.postService.findById(id);
//        UserServiceModel user = this.userService.findByUsername(principal.getName());
//
//        if (!(postServiceModel.getUploader().getUsername().equals(user.getUsername()) ||
//                user.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_MODERATOR"))
//                || user.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN")))) {
//            return redirect("/dashboard");
//        }
//        bindingModel = this.mapper.map(postServiceModel, PostEditBindingModel.class);
//        modelAndView.addObject("bindingModel", bindingModel);
//        return view("post-edit");
//    }


//@GetMapping("/update/{id}")
//    public String update (@PathVariable Long id, Model model){
//Optional<Item> item = itemService.updateItem(id);
//
//           if(item.isPresent()){
//            model.addAttribute("itemAddBindingModel",item.get());
//
//            return "update-item";
//        }else {
//            return "error-404";
//        }
//
//    }



//    @PostMapping("/update/{id}")
//    public String confirmUpdateItem(@PathVariable Long id, ModelMapper modelMapper,
//                                       ItemAddBindingModel itemAddBindingModel,
//                                       @AuthenticationPrincipal UserDetails principal) {
//
//        ItemServiceModel itemServiceModel = modelMapper
//                .map(itemAddBindingModel, ItemServiceModel.class);
//        itemServiceModel.setUser(principal.getUsername());
//        itemService.addItem(itemServiceModel);
//        return "redirect:/items/all";
//    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        itemService.delete(id);
        return "redirect:/home";
    }


//@GetMapping("/delete/{id}")
//public String delete (@PathVariable("id") Long id){
//this.articleService.delete(id);
//return "redirect:/articles/all";
//}

//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable Long id,
//                         Model model) {
//
//        offerService.delete(id);
//
//        return "redirect:/offers/all";
//    }




}