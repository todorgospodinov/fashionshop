package softuni.fashionshop.service;

import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.model.view.BrandViewModel;

import java.util.List;

public interface BrandService {

    void seedBrands();
List<String> findAllBrands();

    Brand findByName(String brand);
}
