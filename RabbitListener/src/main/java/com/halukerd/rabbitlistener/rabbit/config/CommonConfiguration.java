package com.halukerd.rabbitlistener.rabbit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

    @Bean("readValueOLan")
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
