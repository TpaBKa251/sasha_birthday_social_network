package com.example.sasha_birthday_social_network.service;

import com.example.sasha_birthday_social_network.dto.answer.AnswerGreeting;
import com.example.sasha_birthday_social_network.dto.request.GreetingDto;

import java.io.IOException;
import java.util.List;

public interface GreetingService {
    AnswerGreeting addGreeting(GreetingDto body) throws IOException;

    List<AnswerGreeting> getAllGreeting();
}
