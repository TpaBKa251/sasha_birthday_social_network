package com.example.sasha_birthday_social_network.controller;

import com.example.sasha_birthday_social_network.dto.answer.AnswerGreeting;
import com.example.sasha_birthday_social_network.dto.request.GreetingDto;
import com.example.sasha_birthday_social_network.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("sasha/birthday/social/network")
@RequiredArgsConstructor
public class ControllerGreeting {

    private final GreetingService greetingService;

    @PostMapping
    public AnswerGreeting greet(
            @RequestParam("name") String name,
            @RequestParam("message") String message,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "video", required = false) MultipartFile video) throws IOException {

        GreetingDto greetingDto = new GreetingDto(name, message, image, video);
        return greetingService.addGreeting(greetingDto);
    }

    @GetMapping("/get")
    public List<AnswerGreeting> getGreetings() {
        return greetingService.getAllGreeting();
    }
}

