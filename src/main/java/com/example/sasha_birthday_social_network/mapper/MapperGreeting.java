package com.example.sasha_birthday_social_network.mapper;

import com.example.sasha_birthday_social_network.dto.answer.AnswerGreeting;
import com.example.sasha_birthday_social_network.entity.Greeting;

public class MapperGreeting {

    public static AnswerGreeting map(Greeting greeting) {
        return new AnswerGreeting(
                greeting.getName(),
                greeting.getMessage(),
                greeting.getImageUrl(),
                greeting.getVideoUrl()
        );
    }
}
