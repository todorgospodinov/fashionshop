package softuni.fashionshop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.fashionshop.model.entity.Role;
import softuni.fashionshop.model.entity.enums.RoleEnum;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.repository.RoleRepository;
import softuni.fashionshop.repository.UserRepository;

import java.util.List;

    @Component
    public class SecurityApplicationInit  implements CommandLineRunner {

        private final UserRepository userRepository;
        private final RoleRepository userRoleRepository;
        private final PasswordEncoder passwordEncoder;

        public SecurityApplicationInit(
                UserRepository userRepository,
                RoleRepository roleRepository,
                PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.userRoleRepository = roleRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args)  {


            if (userRepository.count()==0 ) {
                Role userRole = userRoleRepository.save(new Role().setRole(RoleEnum.USER));
                Role adminRole = userRoleRepository.save(new Role().setRole(RoleEnum.ADMIN));

                //simple user
                UserEntity user = new UserEntity();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("topsecret"));
                user.setRoles(List.of(userRole));

                UserEntity admin = new UserEntity();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("topsecret"));
                admin.setRoles(List.of(adminRole, userRole));

                userRepository.save(user);
                userRepository.save(admin);
            }

        }


}
