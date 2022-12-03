package com.read.excle.propertiesfile.readfile.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Configuration
public class JsonFormatConfig {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT);
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(){
        DateFormat dateFormat=sdf1;
return builder ->{
    builder.indentOutput(true);
    builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
};
    }



}

