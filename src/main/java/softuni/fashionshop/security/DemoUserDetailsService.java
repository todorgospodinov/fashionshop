package softuni.fashionshop.security;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.repository.RoleRepository;
import softuni.fashionshop.repository.UserRepository;

@Component
public class DemoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public DemoUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User with name " + username + " was not found."));

        return mapToUserDetails(userEntity);
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {

        List<SimpleGrantedAuthority> authorities = userEntity.
                getRoles().
                stream().
                map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.getRole().name())).
                collect(Collectors.toList());

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );
    }
}