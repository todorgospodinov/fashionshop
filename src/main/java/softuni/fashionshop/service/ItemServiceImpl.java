package softuni.fashionshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.model.view.ItemViewModel;
import softuni.fashionshop.repository.ItemRepository;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelmapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelmapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = this.modelMapper.map(itemServiceModel, Item.class);
        item.setCategory(this.categoryService.find(itemServiceModel.getCategory().getCategoryEnum()));
        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        //този стреам мапва от айтъми към айтъмвюмодели

        return this.itemRepository.findAll().stream().map(item -> {
            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getCategoryEnum().name()));
            return itemViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        return this.itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getCategoryEnum().name()));
                    return itemViewModel;
                }).orElse(null);
    }

    @Override
    public BigDecimal getTotalSum() {
        return itemRepository.findTotalItemsSum();
    }

    @Override
    public List<ItemViewModel> findAllItemsByCategoryEnum(CategoryEnum categoryEnum) {
        return itemRepository.findAllByCategory_CategoryEnum(categoryEnum).stream()
                .map(item -> modelMapper
                        .map(item,ItemViewModel.class)).collect(Collectors.toList());
    }



    @Override
    public void delete(Long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public void buyById(Long id) {
        itemRepository.deleteById(id);
    }

}