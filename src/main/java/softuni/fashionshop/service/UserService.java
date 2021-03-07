package softuni.fashionshop.service;

import softuni.fashionshop.model.service.UserRegistrationServiceModel;

    public interface UserService {

        void seedUsers();

        void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

        boolean userNameExists(String username);
    }

