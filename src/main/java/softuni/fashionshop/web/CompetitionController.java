package softuni.fashionshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softuni.fashionshop.model.service.CompetitionServiceModel;
import softuni.fashionshop.service.CompetitionService;

import java.io.IOException;

@Controller
@RequestMapping("/cloud")
public class CompetitionController {
    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/all")
    public String open(Model model) {

        model.addAttribute("competitions", this.competitionService.findAll());

        return "competition";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("competitionServiceModel")
            CompetitionServiceModel competitionServiceModel) throws IOException {
        this.competitionService.addCompetition(competitionServiceModel);
        model.addAttribute("competitions", this.competitionService.findAll());

        return "competition";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id){
        this.competitionService.delete(id);
        return "redirect:/cloud/all";
    }
}

