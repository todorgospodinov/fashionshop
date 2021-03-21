package softuni.fashionshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.fashionshop.model.service.CompetitionServiceModel;
import softuni.fashionshop.service.CompetitionService;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;

@Controller
public class CompetitionController {
    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping("/cloud")
    public String add(Model model, @ModelAttribute("competitionServiceModel")
            CompetitionServiceModel competitionServiceModel) throws IOException {
        this.competitionService.addCompetition(competitionServiceModel);
        model.addAttribute("competitions", this. competitionService.findAll());

        return "competition";
    }

}

// @PostMapping("/add")
//    public String add(Model model,  @ModelAttribute("studentServiceModel")
//        StudentServiceModel studentServiceModel) throws IOException {
//
//        this.studentService.addStudent(studentServiceModel);
//        model.addAttribute("students", this.studentService.findAll());
//        return "home";
//    }