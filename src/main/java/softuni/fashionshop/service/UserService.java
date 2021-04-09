package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.RoleEnum;
import softuni.fashionshop.model.service.UserRegistrationServiceModel;

import java.util.List;

public interface UserService {

        void seedUsers();

        void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

        boolean userNameExists(String username);

        UserEntity findByName(String username);

        List<String> findAllUsernames();

    void changeRole(String username, RoleEnum roleEnum);
}

