//package softuni.fashionshop.web;
//
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import softuni.fashionshop.model.entity.Brand;
//
//import softuni.fashionshop.model.entity.Item;
//import softuni.fashionshop.model.entity.UserEntity;
//import softuni.fashionshop.model.entity.enums.CategoryEnum;
//import softuni.fashionshop.repository.BrandRepository;
//import softuni.fashionshop.repository.ItemRepository;
//import softuni.fashionshop.repository.UserRepository;
////integration test
////vdiga celiq testovi context na SpringBoot
//@SpringBootTest
////s nego mojem da isprastame get i post zaqvki
//@AutoConfigureMockMvc
//@AutoConfigureTestDatabase
//public class ItemControllerTest {
//
//    private static final String ITEM_CONTROLLER_PREFIX = "/items";
//
//    private long testItemId;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BrandRepository brandRepository;
//    @Autowired
//    private ItemRepository itemRepository;
//
//    @BeforeEach
//    public void setup() {
//        this.init();
//    }
//
//    @Test
//    @WithMockUser(value = "pesho", roles = {"USER", "ADMIN"})
//    void testShouldReturnValidStatusViewNameAndModel() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get(
//                ITEM_CONTROLLER_PREFIX + "/details/{id}", testItemId
//        )).
//                andExpect(status().isOk()).
//                andExpect(view().name("details")).
//                andExpect(model().attributeExists("item"));
//    }
//
//    @Test
//    //izpozva se kogato trqbva authentificaciq sus security - suzdava pravilen context
//    @WithMockUser(value = "pesho", roles = {"USER", "ADMIN"})
//    void addItem() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post(ITEM_CONTROLLER_PREFIX + "/add")
//                .param("name", "test item").
//                        param("category", CategoryEnum.SHIRT.name()).
//                        param("imageUrl", "http://example.com/image.png").
//                        param("videoUrl", "_fKAsvJrFes").
//                        param("description", "Description test").
//                        param("price", "10").
//                        param("receivedOn", "2000-01-01").
//                        param("brand", "Armani").
//                        with(csrf())).
//                andExpect(status().is3xxRedirection());
//
//        Assertions.assertEquals(2, itemRepository.count());
//        //todo: may verify the created album properties
//    }
//
//    private void init() {
//        Brand brandEntity = new Brand();
//        brandEntity.setName("Armani");
//        brandEntity.setDescription("Some info about metallica");
//        brandEntity = brandRepository.save(brandEntity);
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("pesho").setPassword("xyz").setFullName("petar petrov");
//        userEntity = userRepository.save(userEntity);
//
//        Item itemEntity = new Item();
//                itemEntity.
//                setName("teniska").
//                setImageUrl("https://upload.wikimedia.org/wikipedia/en/b/bd/Metallica_-_...And_Justice_for_All_cover.jpg").
//                setVideoUrl("_fKAsvJrFes").
//                setDescription("Sample description").
//                setPrice(BigDecimal.TEN).
//                setRecivedOn(LocalDate.of(1988, 3, 3)
//                        .atStartOfDay(ZoneId.systemDefault()).toInstant()).
//                setCategoryEnum(CategoryEnum.SHIRT).
//                setBrand(brandEntity).
//                setUserEntity(userEntity);
//
//
//        itemEntity = itemRepository.save(itemEntity);
//        testItemId = itemEntity.getId();
//    }
//}
//
