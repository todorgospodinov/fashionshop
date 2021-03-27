//package softuni.fashionshop.service;
//
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.when;
//
//class ItemServiceTests{
//    @Test
//    void shouldItem(){
//        ItemService itemService = Mockito.mock(ItemService.class);
//    when(itemService.addItem()).thenReturn();
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////class UserServiceTests{
////    private UserEntity testUserEntity;
////    private UserRepository mockUserRepository;
////
////    @Before
////    public void init() {
////        this.testUserEntity=new UserEntity(){{
////            setId((long) 10);
////            setUsername("pesho");
////            setPassword("12345");
////        }};
////        this.mockUserRepository= Mockito.mock(UserRepository.class);
////    }
////
////    @Test
////    public void UserServiceGetUserCorrect(){
////        //Arrange
////
////        Mockito.when(this.mockUserRepository.findByUsername("pesho")).thenReturn(this.testUserEntity);
////                UserService userService = new UserServiceImpl(this.mockUserRepository);
////                UserEntity expected=this.testUserEntity;
////
////        //Act
////
////        //Assert
////
////
////
////
////    }
////}
//
//
////
////
////import org.junit.Before;
////import org.junit.jupiter.api.Test;
////import org.junit.runner.RunWith;
////import org.mockito.Mock;
////import org.mockito.junit.MockitoJUnitRunner;
////import org.modelmapper.ModelMapper;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import softuni.fashionshop.repository.UserRepository;
////
////@RunWith(MockitoJUnitRunner.class)
////    public class UserServiceTests {
////
////        @Mock
////        UserRepository mockUserRepository;
////        @Mock
////        RoleService mockRoleService;
////        @Mock
////        BCryptPasswordEncoder mockEncoder;
////        @Mock
////        EmailService mockEmailService;
////
////        UserServiceImpl serviceToTest;
////
////        @Before
////        public void initTests() {
////            serviceToTest = new UserServiceImpl(
////                    new ModelMapper(),
////                    mockUserRepository,
////                    mockRoleService,
////                    mockEmailService,
////                    mockEncoder
////            );
////
////        }
////
////        @Test
////        public void findUserByUsername_WhenUserExist_ShouldWork() {
////
////            // setup a test user
////            User testUser = new User();
////            testUser.setUsername("pesho");
////            testUser.setEmail("pesho@example.com");
////            //todo: more props here...
////            Role sampleRole = new Role();
////            sampleRole.setAuthority("TEST_AUTHORITY");
////            testUser.setAuthorities(Set.of(sampleRole));
////
////            // configure the mock user repo
////            Mockito.when(mockUserRepository.findUserByUsername("pesho"))
////                    .thenReturn(Optional.of(testUser));
////
////            // test
////            UserServiceModel result = serviceToTest.findUserByUsername("pesho");
////
////            //verify
////            Assert.assertEquals(result.getUsername(), testUser.getUsername());
////            Assert.assertEquals(result.getEmail(), testUser.getEmail());
////            Assert.assertEquals(1, result.getAuthorities().size());
////            //todo compare if the role is correct
////        }
////    }
////
////
