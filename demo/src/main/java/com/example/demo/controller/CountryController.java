package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {

    private final CountryRepository repo;

    @PostMapping
    public Country add(@RequestBody Country c) {
        return repo.save(c);
    }

    @GetMapping
    public List<Country> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable String id, @RequestBody Country c) {
        Country existing = repo.findById(id).orElseThrow();
        existing.setName(c.getName());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}