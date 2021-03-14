package softuni.fashionshop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CarouselServiceImpl implements CarouselService {

    private final Logger LOGGER = LoggerFactory.getLogger(CarouselServiceImpl.class);

    private final List<String> images = new ArrayList<>();

    public CarouselServiceImpl(@Value("${images}") List<String> images) {
        this.images.addAll(images);
    }

    @PostConstruct
    public void afterInitialize() {
        if (images.size() < 3) {
            throw new IllegalArgumentException("Must configure at least three images...");
        }
    }

    @Override
    public String firstImage() {
        return images.get(0);
    }

    @Override
    public String secondImage() {
        return images.get(1);
    }

    @Override
    public String thirdImage() {
        return images.get(2);
    }


    @Scheduled(cron = "* */3 * * * *")
    public void refresh() {
        LOGGER.info("Shuffling images...");
        Collections.shuffle(images);
    }
}