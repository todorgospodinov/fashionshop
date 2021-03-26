//package softuni.fashionshop.web;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.hamcrest.Matchers.is;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mockito;
//import org.mockito.stubbing.Answer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import softuni.fashionshop.model.entity.Item;
//import softuni.fashionshop.repository.ItemRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ItemControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private ItemRepository mockItemRepository;
//
//    private Item item1;
//    private Item item2;
//
//    private Long NEW_ITEM_ID;
//    private Long NON_EXISTING_ITEM_ID;
//
//
//    @BeforeEach
//    public void setUp() {
//
//        item1 = new Item().setId(1).setName("Author 1");
//        item2 = new Item().setId(2).setName("Author 2");
//
//        when(mockItemRepository.findById(item1.getId())).thenReturn(Optional.of(item1));
//        when(mockItemRepository.findById(item2.getId())).thenReturn(Optional.of(item2));
//        when(mockItemRepository.findAll()).thenReturn(List.of(item1, item2));
//
//        when(mockItemRepository.save(any())).thenAnswer(
//                (Answer<Item>) invocation -> {
//                    Item itemToSave = invocation.getArgument(0);
//                    itemToSave.setId((long)NEW_ITEM_ID);
//                    return itemToSave;
//                }
//        );
//    }
//
//    @Test
//    public void testAuthorsReturnsCorrectStatusCode() throws Exception {
//        this.mockMvc.perform(get("/items")).
//                andExpect(status().isOk());
//    }
//
//
//
//    @Test
//    public void testAuthorNotFound() throws Exception {
//        this.mockMvc.perform(get("/items/{id}", NON_EXISTING_ITEM_ID)).
//                andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void testAuthor1Found() throws Exception {
//        this.mockMvc.
//                perform(get("/authors/{id}", item1.getId())).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("$.name", is(item1.getName())));
//    }
//
//    @Test
//    public void testAuthor2Found() throws Exception {
//        this.mockMvc.
//                perform(get("/authors/{id}", item2.getId())).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("$.name", is(item2.getName())));
//    }
//
//    @Test
//    public void testAllAuthors() throws Exception {
//        this.mockMvc.
//                perform(get("/authors")).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("$", hasSize(2))).
//                andExpect(jsonPath("$.[0].id", is( item1.getId()))).
//                andExpect(jsonPath("$.[0].name", is(item1.getName()))).
//                andExpect(jsonPath("$.[1].id", is( item2.getId()))).
//                andExpect(jsonPath("$.[1].name", is(item2.getName())));
//    }
//
//    @Test
//    public void testCreateNewAuthor() throws Exception {
//        Item newAuthorExpected = new Item().setName("NEW AUTHOR");
//        String json = objectMapper.writeValueAsString(newAuthorExpected);
//
//        this.mockMvc.perform(
//                post("/authors").
//                        contentType(MediaType.APPLICATION_JSON).
//                        content(json).
//                        accept(MediaType.APPLICATION_JSON)).
//                andExpect(status().isCreated());
//
//        ArgumentCaptor<Item> argument = ArgumentCaptor.forClass(Item.class);
//        Mockito.verify(mockItemRepository, times(1)).save(argument.capture());
//
//        Item newAuthorActual = argument.getValue();
//
//        Assertions.assertEquals(newAuthorExpected.getName(), newAuthorActual.getName());
//        Assertions.assertEquals(NEW_ITEM_ID, newAuthorActual.getId());
//    }
//
//}
