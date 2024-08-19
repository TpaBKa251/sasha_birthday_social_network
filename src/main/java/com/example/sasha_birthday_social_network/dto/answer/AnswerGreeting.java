package com.example.sasha_birthday_social_network.dto.answer;

/**
 * DTO for {@link com.example.sasha_birthday_social_network.entity.Greeting}
 */

public record AnswerGreeting(
        String name,

        String message,

        String imageUrl,

        String videoUrl
) {
}