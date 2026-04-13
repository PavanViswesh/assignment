package com.example.demo.repository;

import com.example.demo.entity.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language, String> {
}