package softuni.fashionshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softuni.fashionshop.model.entity.enums.RoleEnum;
import softuni.fashionshop.service.UserService;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/add")
    public String add(Model model){
model.addAttribute("names",userService.findAllUsernames());
        return "add-role";
    }

    @PostMapping("/add")
    public String addConfirm(
            @RequestParam String username,
            @RequestParam String role){

        userService.changeRole(username, RoleEnum.valueOf(role.toUpperCase()));
        return "redirect:/home";
    }
 }
