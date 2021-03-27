//package softuni.fashionshop.service;
//
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import softuni.fashionshop.model.entity.Role;
//import softuni.fashionshop.model.entity.UserEntity;
//import softuni.fashionshop.repository.UserRepository;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class FashionShopUserServiceTest {
//    private FashionShopUserService serviceToTest;
//    private String TEST_USER_NAME_EXIST="tosho";
//    private String TEST_USER_NAME_NON_EXIST="anna";
//    private UserEntity testUserEntity;
//    private Role testRole;
//
//
//    @Mock
//    private UserRepository mockUserRepository;
//    @BeforeEach
//    public void setUp(){
//        testRole = new Role();
//testRole.setRole("USER");
//        testUserEntity = new UserEntity();
//        testUserEntity.setUsername("tosho");
//        testUserEntity.setPassword("12345");
//        serviceToTest=new FashionShopUserService(mockUserRepository);
//
//
//    }
//
//    @Test
//    public void testUserNotFound(){
//        when(mockUserRepository.findByUsername(TEST_USER_NAME_NON_EXIST))
//                .thenReturn(Optional.empty());
//
//        Assertions.assertThrows(UsernameNotFoundException.class, ()-> {
//            serviceToTest.loadUserByUsername(TEST_USER_NAME_NON_EXIST);
//        });
//        }
//
//    @Test
//    public void testUserFound(){
//        when(mockUserRepository.findByUsername(TEST_USER_NAME_EXIST))
//                .thenReturn(Optional.of(testUserEntity));
//
//        Assertions.assertEquals(test);
//        });
//    }
//
//}
