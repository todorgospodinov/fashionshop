package softuni.fashionshop.web;

import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.entity.Item;
import softuni.fashionshop.model.entity.UserEntity;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.repository.BrandRepository;
import softuni.fashionshop.repository.ItemRepository;
import softuni.fashionshop.repository.LogRepository;
import softuni.fashionshop.repository.UserRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

public class ItemTestData {
    private long testItemId;

    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private ItemRepository itemRepository;
    private LogRepository logRepository;

    public ItemTestData(UserRepository userRepository, BrandRepository brandRepository, ItemRepository itemRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.itemRepository = itemRepository;
        this.logRepository = logRepository;
    }

    void init() {

        Brand brandEntity = new Brand();
        brandEntity.setName("Armani");
        brandEntity.setDescription("Some info about Armani");
        brandEntity = brandRepository.save(brandEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("tosho").setPassword("12345").setFullName("Tosho Toshev");
        userEntity = userRepository.save(userEntity);

        Item teniskaArmani = new Item();
        teniskaArmani.
                setName("teniska").
                setImageUrl("https://img.giglio.com/images/prodZoom/321320.009_3.jpg").
                setVideoUrl("zundkVVEOiY").
                setDescription("Sample description").
                setPrice(BigDecimal.TEN).
                setReceivedOn(LocalDate.of(2018, 3, 3)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()).
                setCategoryEnum(CategoryEnum.SHIRT).
                setBrand(brandEntity).
                setUserEntity(userEntity);

        teniskaArmani = itemRepository.save(teniskaArmani);

        Item obuvkiBode = new Item();
        obuvkiBode.
                setName("obuvki").
                setImageUrl("https://i.pinimg.com/originals/78/52/13/7852130c0e9b7e241475d9a9e012ef0e.jpg").
                setVideoUrl("vpLG5N-Iv-4").
                setDescription("Sample description").
                setPrice(BigDecimal.TEN).
                setReceivedOn(LocalDate.of(2019, 3, 3)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()).
                setCategoryEnum(CategoryEnum.SHOES).
                setBrand(brandEntity).
                setUserEntity(userEntity);

        obuvkiBode = itemRepository.save(obuvkiBode);


        testItemId = teniskaArmani.getId();
    }

    void cleanUp() {
        logRepository.deleteAll();
        itemRepository.deleteAll();
        brandRepository.deleteAll();
        userRepository.deleteAll();
    }


    public long getTestItemId() {
        return testItemId;
    }

}
