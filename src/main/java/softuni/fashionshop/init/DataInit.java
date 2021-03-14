package softuni.fashionshop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.fashionshop.service.BrandService;


@Component
public class DataInit implements CommandLineRunner {

    private final BrandService brandService;

    public DataInit(BrandService brandService) {
        this.brandService = brandService;
    }


    @Override
    public void run(String... args) throws Exception {
        brandService.seedBrands();
    }
}
