package softuni.fashionshop.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.entity.LogEntity;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.service.LogServiceModel;
import softuni.fashionshop.repository.LogRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;
    private final ItemService itemService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public LogServiceImpl(LogRepository logRepository, ItemService itemService, UserService userService, ModelMapper modelMapper) {
        this.logRepository = logRepository;
        this.itemService = itemService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createLog(String action, Long itemId) {
        Item item = itemService.findEntityById(itemId);

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String username = authentication.getName();
        UserEntity userEntity = userService.findByName(username);

        LogEntity logEntity = new LogEntity()
                .setItem(item)
                .setUserEntity(userEntity)
                .setAction(action)
                .setDateTime(LocalDateTime.now());

        logRepository.save(logEntity);

    }

    @Override
    public List<LogServiceModel> findAllLogs() {
        return logRepository
                .findAll()
                .stream()
                .map(logEntity -> {
                    LogServiceModel logServiceModel = modelMapper
                            .map(logEntity, LogServiceModel.class);
                    logServiceModel.setItem(logEntity.getItem().getName())
                            .setUser(logEntity.getUserEntity().getUsername());

                    return logServiceModel;
                })
                .collect(Collectors.toList());
    }
}