package softuni.fashionshop.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softuni.fashionshop.model.entity.Category;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.model.view.ItemViewModel;
import softuni.fashionshop.repository.CategoryRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
                Category category = new Category(categoryEnum, "Description for " + categoryEnum.name());
                categoryRepository.save(category);
            });
        }
    }



//    @Override
//    public List<ItemViewModel> findAllItemsByCategoryEnum(CategoryEnum categoryEnum) {
//        return null;
//    }


    @Override
    public Category find(CategoryEnum categoryEnum) {
     return this.categoryRepository.findByCategoryEnum(categoryEnum).orElse(null);
  }

    @Override
    public Collection<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

//    @Override
//    public Collection<Category> getAllCategories() {
//        return categoryRepository.findAll(Sort.by("categoryEnum"));
//    }

}
