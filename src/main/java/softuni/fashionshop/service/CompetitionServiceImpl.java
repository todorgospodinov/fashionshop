package softuni.fashionshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import softuni.fashionshop.model.entity.Competition;
import softuni.fashionshop.model.service.CompetitionServiceModel;
import softuni.fashionshop.model.view.CompetitionViewModel;
import softuni.fashionshop.repository.CompetitionRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CloudinaryService cloudinaryService;
    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;

    public CompetitionServiceImpl(CloudinaryService cloudinaryService, CompetitionRepository competitionRepository, ModelMapper modelMapper) {
        this.cloudinaryService = cloudinaryService;
        this.competitionRepository = competitionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCompetition(CompetitionServiceModel competitionServiceModel) throws IOException {
        MultipartFile img = competitionServiceModel.getImageUrl();
        String url = cloudinaryService.uploadImage(img);

        Competition competition = new Competition().setImageUrl(url);

        competitionRepository.save(competition);
    }

    @Override
    public List<CompetitionViewModel> findAll() {
        return competitionRepository.
                findAll().
                stream().
                map(c -> modelMapper.map(c, CompetitionViewModel.class)).
                collect(Collectors.toList());
    }
}