package softuni.fashionshop.config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import softuni.fashionshop.stats.StatsInterceptor;
//WebMvcConfigurer ни позволява да се регистрираме в интерсептор регистри чрез метода InterceptorRegistry registry

@Component
public class WebConfig implements WebMvcConfigurer {

    private StatsInterceptor statsInterceptor;

    public WebConfig(StatsInterceptor statsInterceptor) {
        this.statsInterceptor = statsInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statsInterceptor);
    }

}
