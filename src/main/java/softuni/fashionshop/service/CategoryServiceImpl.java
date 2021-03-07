//package softuni.fashionshop.service;
//
//import org.springframework.stereotype.Service;
//import softuni.fashionshop.model.entity.Category;
//import softuni.fashionshop.model.entity.CategoryName;
//import softuni.fashionshop.repository.CategoryRepository;
//
//import java.util.Arrays;
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//    private final CategoryRepository categoryRepository;
//
//    public CategoryServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public void initCategories() {
//        if (categoryRepository.count() == 0) {
//            Arrays.stream(CategoryName.values()).forEach(categoryName -> {
//                Category category = new Category(categoryName, "Description for " + categoryName.name());
//                categoryRepository.save(category);
//            });
//
//        }
//    }
//
//    @Override
//    public Category find(CategoryName categoryName) {
//        return this.categoryRepository.findByCategoryName(categoryName).orElse(null);
//    }
//}
