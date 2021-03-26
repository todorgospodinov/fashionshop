//package softuni.fashionshop.service;
//
//
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import softuni.fashionshop.repository.UserRepository;
//
//@RunWith(MockitoJUnitRunner.class)
//    public class UserServiceTests {
//
//        @Mock
//        UserRepository mockUserRepository;
//        @Mock
//        RoleService mockRoleService;
//        @Mock
//        BCryptPasswordEncoder mockEncoder;
//        @Mock
//        EmailService mockEmailService;
//
//        UserServiceImpl serviceToTest;
//
//        @Before
//        public void initTests() {
//            serviceToTest = new UserServiceImpl(
//                    new ModelMapper(),
//                    mockUserRepository,
//                    mockRoleService,
//                    mockEmailService,
//                    mockEncoder
//            );
//
//        }
//
//        @Test
//        public void findUserByUsername_WhenUserExist_ShouldWork() {
//
//            // setup a test user
//            User testUser = new User();
//            testUser.setUsername("pesho");
//            testUser.setEmail("pesho@example.com");
//            //todo: more props here...
//            Role sampleRole = new Role();
//            sampleRole.setAuthority("TEST_AUTHORITY");
//            testUser.setAuthorities(Set.of(sampleRole));
//
//            // configure the mock user repo
//            Mockito.when(mockUserRepository.findUserByUsername("pesho"))
//                    .thenReturn(Optional.of(testUser));
//
//            // test
//            UserServiceModel result = serviceToTest.findUserByUsername("pesho");
//
//            //verify
//            Assert.assertEquals(result.getUsername(), testUser.getUsername());
//            Assert.assertEquals(result.getEmail(), testUser.getEmail());
//            Assert.assertEquals(1, result.getAuthorities().size());
//            //todo compare if the role is correct
//        }
//    }
//
//
