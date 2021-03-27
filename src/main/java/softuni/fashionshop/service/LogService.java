package softuni.fashionshop.service;

import softuni.fashionshop.model.service.LogServiceModel;

import java.util.List;

public interface LogService {
    void createLog(String action, Long itemId);

    List<LogServiceModel> findAllLogs();


}
