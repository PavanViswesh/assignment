package com.example.demo.controller;

import com.example.demo.entity.Language;
import com.example.demo.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // 🔥 remove space
@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageRepository repo;

    // ✅ ADD
    @PostMapping
    public Language add(@RequestBody Language language) {
        return repo.save(language);
    }

    // ✅ GET ALL
    @GetMapping
    public List<Language> getAll() {
        return repo.findAll();
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Language update(@PathVariable String id, @RequestBody Language language) {

        Language existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        existing.setName(language.getName());

        return repo.save(existing);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}