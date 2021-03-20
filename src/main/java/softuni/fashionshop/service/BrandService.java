package softuni.fashionshop.service;

import softuni.fashionshop.model.view.BrandViewModel;

import java.util.List;

public interface BrandService {
    void seedBrands();
List<String> findAllBrands();
}
