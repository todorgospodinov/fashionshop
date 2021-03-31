package softuni.fashionshop.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
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

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase

public class ItemRestControllerTest {

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
    public void setUp() {
        testData = new ItemTestData(
                userRepository,
                brandRepository,
                itemRepository,
                logRepository
        );
        testData.init();
    }

    @AfterEach
    public void tearDown() {
        testData.cleanUp();
    }

    @Test
    @WithMockUser(value = "tosho", roles = {"USER", "ADMIN"})
    void testFetchAlbums() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/items/api")).
                andExpect(status().isOk()).
                andExpect(jsonPath("[0].name").value("teniska")).
                andExpect(jsonPath("[0].price").value(10)).
                andExpect(jsonPath("[0].categoryEnum").value(CategoryEnum.SHIRT.toString())).
                andExpect(jsonPath("[1].name").value("obuvki")).
                andExpect(jsonPath("[1].price").value(10)).
                andExpect(jsonPath("[1].categoryEnum").value(CategoryEnum.SHOES.toString()));
    }


}
