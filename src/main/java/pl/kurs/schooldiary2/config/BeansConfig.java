package pl.kurs.schooldiary2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class BeansConfig {


    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }

}
