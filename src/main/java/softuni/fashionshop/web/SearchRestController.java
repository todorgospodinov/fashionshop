package softuni.fashionshop.web;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.view.ItemViewModel;
import softuni.fashionshop.repository.ItemRepository;

@RequestMapping("/items")
@RestController
public class SearchRestController {


    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;

    public SearchRestController(ItemRepository itemRepository,
                               ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api")
    public ResponseEntity<List<ItemViewModel>> findAll() {
List<ItemViewModel>itemViewModels = itemRepository.
        findAll().
        stream().
        map(ie->{
            ItemViewModel viewModel = modelMapper.map(ie,ItemViewModel.class);
            viewModel.setBrand(ie.getBrand().getName());
        return viewModel;
        }).
        collect(Collectors.toList());


        return ResponseEntity.ok().body(itemViewModels);
    }

}
