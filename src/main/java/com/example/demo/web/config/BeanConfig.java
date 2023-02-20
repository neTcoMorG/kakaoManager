package com.example.demo.web.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

    @Bean
    public WebClient webClient () { return WebClient.builder().build(); }
}
