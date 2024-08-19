package com.example.sasha_birthday_social_network.service.serviceImpl;

import com.example.sasha_birthday_social_network.dto.answer.AnswerGreeting;
import com.example.sasha_birthday_social_network.dto.request.GreetingDto;
import com.example.sasha_birthday_social_network.entity.Greeting;
import com.example.sasha_birthday_social_network.mapper.MapperGreeting;
import com.example.sasha_birthday_social_network.repository.GreetingRepository;
import com.example.sasha_birthday_social_network.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {
    private final GreetingRepository greetingRepository;

    @Override
    public AnswerGreeting addGreeting(GreetingDto body) throws IOException {
        Greeting greeting = new Greeting();

        greeting.setName(body.name());
        greeting.setMessage(body.message());
        greeting.setImageUrl(body.imageUrl() != null ? saveFile(body.imageUrl()) : null);
        greeting.setVideoUrl(body.videoUrl() != null ? saveFile(body.videoUrl()) : null);

        greetingRepository.save(greeting);

        return MapperGreeting.map(greeting);
    }

    @Override
    public List<AnswerGreeting> getAllGreeting() {
        List<Greeting> greetings = greetingRepository.findAll();

        return greetings.stream()
                .map(MapperGreeting::map)
                .toList();
    }

    // Метод для сохранения файла на сервере и возврата URL
    private String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }

        // Генерация уникального имени файла
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Путь к директории uploads
        String uploadDir = "uploads";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Сохранение файла
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Возврат URL файла
        return "/uploads/" + fileName;
    }
}
