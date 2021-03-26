package softuni.fashionshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.fashionshop.service.LogService;

@Controller
@RequestMapping("/statistics")
public class StatsItemController {
    private final LogService logService;
    public StatsItemController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public String stats(Model model){
model.addAttribute("logs",logService.findAllLogs());

        return "stats-item";
    }

}
