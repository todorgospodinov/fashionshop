//package softuni.fashionshop.web;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import softuni.fashionshop.model.binding.BrandAddBindingModel;
//import softuni.fashionshop.model.binding.ItemAddBindingModel;
//import softuni.fashionshop.model.service.BrandServiceModel;
//import softuni.fashionshop.model.service.ItemServiceModel;
//import softuni.fashionshop.service.BrandService;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/brands")
//public class BrandController {
//    private final BrandService brandService;
//    private final ModelMapper modelMapper;
//
//
//    public BrandController(BrandService brandService, ModelMapper modelMapper) {
//        this.brandService = brandService;
//        this.modelMapper = modelMapper;
//    }
//
//    @GetMapping("/add")
//    public String add(Model model) {
//        if (!model.containsAttribute("brandAddBindingModel")) {
//            model.addAttribute("brandAddBindingModel", new BrandAddBindingModel());
//        }
//        return "add-item";
//    }
//
//    @PostMapping("/add")
//    public String addConfirm(@Valid @ModelAttribute("brandAddBindingModel")
//                                     BrandAddBindingModel brandAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            return "redirect:add";
//        }
//        this.brandService.addBrand(this.modelMapper.map(brandAddBindingModel, BrandServiceModel.class));
//        return "redirect:/";
//    }
//
//
//
//}
