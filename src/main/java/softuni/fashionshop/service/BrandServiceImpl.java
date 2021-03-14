package softuni.fashionshop.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import softuni.fashionshop.model.entity.Brand;
import softuni.fashionshop.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

    private final Resource brandsFile;
    private final Gson gson;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(@Value("classpath:import/brands.json") Resource brandsFile,
                             Gson gson, BrandRepository brandRepository) {

        this.brandsFile = brandsFile;
        this.gson = gson;
        this.brandRepository = brandRepository;
    }

    @Override
    public void seedBrands() {
        if (brandRepository.count() == 0) {
            try {
                Brand[] brandEntities =
                        gson.fromJson(Files.readString(Path.of(brandsFile.getURI())), Brand[].class);

                Arrays.stream(brandEntities).
                        forEach(brandRepository::save);
            } catch (IOException e) {
                throw new IllegalStateException("Cannot seed artists... :(");
            }
        }
    }
}
