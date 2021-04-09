package softuni.fashionshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.fashionshop.model.entity.Role;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.RoleEnum;
import softuni.fashionshop.model.service.UserRegistrationServiceModel;
import softuni.fashionshop.repository.RoleRepository;
import softuni.fashionshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final FashionShopUserService fashionShopUserService;
    private final PasswordEncoder encoder;

    public UserServiceImpl(RoleRepository roleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper,
                           FashionShopUserService fashionShopUserService, PasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.fashionShopUserService = fashionShopUserService;
        this.encoder = encoder;
    }


    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {

            Role adminRole = new Role().setRole(RoleEnum.ADMIN);
            Role userRole = new Role().setRole(RoleEnum.USER);

            roleRepository.saveAll(List.of(adminRole, userRole));

            UserEntity admin = new UserEntity().setUsername("admin").setFullName("Admin Adminov").setPassword(passwordEncoder.encode("topsecret"));
            UserEntity user = new UserEntity().setUsername("user").setFullName("Bai Ivan").setPassword(passwordEncoder.encode("topsecret"));
            admin.setRoles(List.of(adminRole, userRole));
            user.setRoles(List.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {
        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        Role role = roleRepository.
                findByRole(RoleEnum.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUser.addRole(role);

        newUser = userRepository.save(newUser);

        UserDetails principal = fashionShopUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findByName(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void changeRole(String username, RoleEnum roleEnum) {
        UserEntity userEntity = userRepository
                .findByUsername(username).orElse(null);
        Role role = roleRepository.
                findByRole(roleEnum).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        Role newRole = new Role();
        newRole.setRole(roleEnum);

        if (!userEntity.getRoles().contains(newRole)) {
            userEntity.addRole(role);
            userRepository.save(userEntity);
        }
    }

}


//@Override
//    public void changeRole(String username, RoleEnum roleEnum) {
//       UserEntity userEntity= userRepository
//               .findByUsername(username).orElse(null);
//
//       if(userEntity.getRole().getName() !=roleEnum){
//           userEntity.setRole(roleService.findRole(roleEnum));          }
//userRepository.save(userEntity);
//
//       }
//


