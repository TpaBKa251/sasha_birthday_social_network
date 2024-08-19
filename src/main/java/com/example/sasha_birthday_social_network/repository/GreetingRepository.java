package com.example.sasha_birthday_social_network.repository;

import com.example.sasha_birthday_social_network.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, UUID> {
}