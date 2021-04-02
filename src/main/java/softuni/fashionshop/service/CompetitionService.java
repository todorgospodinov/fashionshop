package softuni.fashionshop.service;


import softuni.fashionshop.model.service.CompetitionServiceModel;
import softuni.fashionshop.model.view.CompetitionViewModel;

import java.io.IOException;
import java.util.List;

public interface CompetitionService {
    void addCompetition(CompetitionServiceModel competitionServiceModel) throws IOException;

    List<CompetitionViewModel> findAll();
}

