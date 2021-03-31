package softuni.fashionshop.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.repository.BrandRepository;
import softuni.fashionshop.repository.ItemRepository;
import softuni.fashionshop.repository.LogRepository;
import softuni.fashionshop.repository.UserRepository;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//integration test
//vdiga celiq testovi context na SpringBoot
@SpringBootTest
//s nego mojem da isprastame get i post zaqvki
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ItemControllerTest {

    private static final String ITEM_CONTROLLER_PREFIX = "/items";
    private long testItemId;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private LogRepository logRepository;
    private ItemTestData testData;

    @BeforeEach
    public void setup() {
        testData = new ItemTestData(userRepository, brandRepository, itemRepository, logRepository);
        testData.init();
        testItemId = testData.getTestItemId();
    }

    @AfterEach
    public void tearDown() {
        testData.cleanUp();
    }

    @Test
    @WithMockUser(value = "tosho", roles = {"USER", "ADMIN"})
    void testShouldReturnValidStatusViewNameAndModel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                ITEM_CONTROLLER_PREFIX + "/details/{id}", testItemId
        )).
                andExpect(status().isOk()).
                andExpect(view().name("details")).
                andExpect(model().attributeExists("item"));
    }

    @Test
    //izpozva se kogato trqbva authentificaciq sus security - suzdava pravilen context
    @WithMockUser(value = "tosho", roles = {"USER", "ADMIN"})
    void addItem() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ITEM_CONTROLLER_PREFIX + "/add")
                .param("name", "test item").
                        param("category", CategoryEnum.SHIRT.name()).
                        param("imageUrl", "http://example.com/image.png").
                        param("videoUrl", "zundkVVEOiY").
                        param("description", "Description test").
                        param("price", "10").
                        param("receivedOn", "2000-01-01").
                        param("brand", "Armani").
                        with(csrf())).
                andExpect(status().is3xxRedirection());

        Assertions.assertEquals(2, itemRepository.count());

    }


}

