package com.example.sasha_birthday_social_network.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO for {@link com.example.sasha_birthday_social_network.entity.Greeting}
 */
public record GreetingDto(
        @NotBlank(message = "Введите имя") 
        String name, 
        
        @NotBlank(message = "Введите сообщение для Александра")
        String message, 
        
        MultipartFile imageUrl,
        
        MultipartFile videoUrl
) {
}