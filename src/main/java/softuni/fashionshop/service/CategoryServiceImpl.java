package softuni.fashionshop.service;

import org.springframework.stereotype.Service;
import softuni.fashionshop.model.entity.Category;
import softuni.fashionshop.model.entity.enums.CategoryEnum;
import softuni.fashionshop.repository.CategoryRepository;

import java.util.Arrays;

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

    @Override
    public Category find(CategoryEnum categoryEnum) {
        return this.categoryRepository.findByCategoryEnum(categoryEnum).orElse(null);
    }
}
