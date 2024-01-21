package com.cz.demo.config;

import com.cz.demo.time.StringToZonedDateTimeConverter;
import com.cz.demo.time.ZonedDateTimeToStringConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    // used when converting from domain object to data object
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Add the custom converter
        modelMapper.addConverter(new ZonedDateTimeToStringConverter("yyyy-MM-dd HH:mm:ssXXX"));
        modelMapper.addConverter(new StringToZonedDateTimeConverter("yyyy-MM-dd HH:mm:ssXXX"));

        return modelMapper;
    }

}
