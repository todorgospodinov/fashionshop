//package softuni.fashionshop.service;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import softuni.fashionshop.model.entity.Brand;
//import softuni.fashionshop.model.entity.enums.BrandEnum;
//import softuni.fashionshop.model.service.BrandServiceModel;
//import softuni.fashionshop.repository.BrandRepository;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//@Service
//public class BrandServiceImpl implements BrandService {
//    private final BrandRepository brandRepository;
//    private final ModelMapper modelMapper;
//
//    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
//        this.brandRepository = brandRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public Collection<Brand> getBrands() {
//        return null;
//    }
//
//    @Override
//    public Brand getBrandById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void addBrand(BrandServiceModel brandServiceModel) {
//        Brand brand = this.modelMapper.map(brandServiceModel, Brand.class);
//              this.brandRepository.saveAndFlush(brand);
//    }
//
//    @Override
//    public void initBrands() {
//if(brandRepository.count()==0){
//    Arrays.stream(BrandEnum.values()).forEach(brandEnum -> {
//        Brand brand = new Brand(brandEnum, brandEnum.name() );
//                brandRepository.save(brand);
//    });
//
//}
//    }
//
////    if (categoryRepository.count() == 0) {
////            Arrays.stream(CategoryEnum.values()).forEach(categoryName -> {
////                Category category = new Category(categoryName, "Description for " + categoryName.name());
////                categoryRepository.save(category);
////            });
////
////        }
//
//
//
//}
