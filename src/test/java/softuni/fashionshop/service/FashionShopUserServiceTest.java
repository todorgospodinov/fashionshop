package softuni.fashionshop.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.fashionshop.model.entity.Role;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.RoleEnum;
import softuni.fashionshop.repository.UserRepository;

//unit test JUnit5

@ExtendWith(MockitoExtension.class)
public class FashionShopUserServiceTest {

    private FashionShopUserService serviceToTest;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    public void setUp() {
        serviceToTest = new FashionShopUserService(mockUserRepository);
    }
    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class, () -> {
                    serviceToTest.loadUserByUsername("user_does_not_exits");
                }
        );
    }

    @Test
    void testExistingUser() {
        // prepare data
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("luchob");
        userEntity.setPassword("xyz");

        Role roleUser = new Role();
        roleUser.setRole(RoleEnum.USER);
        Role roleAdmin = new Role();
        roleAdmin.setRole(RoleEnum.ADMIN);

        userEntity.setRoles(List.of(roleUser, roleAdmin));

        // configure mocks
        Mockito.when(mockUserRepository.findByUsername("luchob")).
                thenReturn(Optional.of(userEntity));

        // test
        UserDetails userDetails = serviceToTest.loadUserByUsername("luchob");

        Assertions.assertEquals(userEntity.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(2, userDetails.getAuthorities().size());

        List<String> authorities = userDetails.
                getAuthorities().
                stream().
                map(GrantedAuthority::getAuthority).
                collect(Collectors.toList());

        Assertions.assertTrue(authorities.contains("ROLE_ADMIN"));
        Assertions.assertTrue(authorities.contains("ROLE_USER"));
    }

}