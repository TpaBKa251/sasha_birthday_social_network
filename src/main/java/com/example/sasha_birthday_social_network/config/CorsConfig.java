package com.example.sasha_birthday_social_network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // на все эндпоинты
                        .allowedOrigins("https://hakaton-zeta.vercel.app") // твой домен фронта
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("Authorization", "X-Trace-Id") // что отдавать во фронт
                        .allowCredentials(true) // если нужны куки/сессии
                        .maxAge(3600);
            }
        };
    }
}

