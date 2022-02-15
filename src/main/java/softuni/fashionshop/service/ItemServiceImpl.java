package softuni.fashionshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.fashionshop.exceptions.ObjectNotFoundException;
import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.service.ItemServiceModel;
import softuni.fashionshop.model.view.ItemViewModel;
import softuni.fashionshop.repository.ItemRepository;
import softuni.fashionshop.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final BrandService brandService;
    private final ModelMapper modelMapper;


    public ItemServiceImpl(ItemRepository itemRepository, BrandService brandService, UserRepository userRepository, ModelMapper modelmapper) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.brandService = brandService;
        this.modelMapper = modelmapper;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        Item item = this.modelMapper.map(itemServiceModel, Item.class);
        UserEntity creator = userRepository.
                findByUsername(itemServiceModel.getUser()).
                orElseThrow(() -> new IllegalArgumentException("Creator " + itemServiceModel.getUser() + " could not be found"));
        item.setUserEntity(creator);

        Brand brand = brandService.findByName(itemServiceModel.getBrand());
        item.setBrand(brand);
        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public ItemViewModel findById(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                 ItemViewModel itemViewModel = modelMapper
                 .map(item,ItemViewModel.class);
                    itemViewModel.setBrand(item.getBrand().getName());
                    return itemViewModel;

                }).orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public Item findEntityById(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(ObjectNotFoundException::new);
    }


    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Collection<Item> getAllItems() {
        return itemRepository.findAll();
    }


//    @Override
//    public Offer deleteOffer(Long id) {
//        Offer old = offerRepo.findById(id).orElseThrow(() ->
//                new EntityNotFoundException(String.format("Offer with ID=%s not found.", id)));
//        offerRepo.deleteById(id);
//        return old;
//    }



//    Item item = this.modelmapper.map(itemServiceModel, Item.class);
//        item.setCategory(this.categoryService.find(itemServiceModel.getCategory().getCategoryName()));
//        this.itemRepository.saveAndFlush(item);



//    @Override
//    public List<ItemViewModel> findAllItems() {
//        //този стреам мапва от айтъми към айтъмвюмодели
//
//        return this.itemRepository.findAll().stream().map(item -> {
//            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
//            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getCategoryEnum().name()));
//            return itemViewModel;
//        }).collect(Collectors.toList());
//    }

//    @Override
//    public ItemViewModel findById(Long id) {
//        return this.itemRepository.findById(id)
//                .map(item -> {
//                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
//
//                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getCategoryEnum().name()));
//                    return itemViewModel;
//                }).orElse(null);
//    }
//
//    @Override
//    public BigDecimal getTotalSum() {
//        return itemRepository.findTotalItemsSum();
//    }
//
//    @Override
//    public List<ItemViewModel> findAllItemsByCategoryEnum(CategoryEnum categoryEnum) {
//        return itemRepository.findAllByCategory_CategoryEnum(categoryEnum).stream()
//                .map(item -> modelMapper
//                        .map(item,ItemViewModel.class)).collect(Collectors.toList());
//    }
//
//
//

//
//    @Override
//    public void buyById(Long id) {
//        itemRepository.deleteById(id);
//    }

//   @Override
//    public Offer updateOffer(Offer offer) {
//        offer.setModified(new Date());
//        Offer old = getOfferById(offer.getId());
//        if (old == null) {
//            throw new EntityNotFoundException(String.format("Offer with ID=%s not found.", offer.getId()));
//        }
//        if (offer.getSeller() != null && offer.getSeller().getId() != old.getSeller().getId())
//            throw new InvalidEntityException("Seller of offer could not ne changed");
//        offer.setSeller(old.getSeller());
//        return offerRepo.save(offer);
//    }
//
//    @Override
//    public Offer deleteOffer(Long id) {
//        Offer old = offerRepo.findById(id).orElseThrow(() ->
//                new EntityNotFoundException(String.format("Offer with ID=%s not found.", id)));
//        offerRepo.deleteById(id);
//        return old;
//    }
//
//    @Override
//    public long getOffersCount() {
//        return offerRepo.count();
//    }


}