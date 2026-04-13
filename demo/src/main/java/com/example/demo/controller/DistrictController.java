package com.example.demo.controller;

import com.example.demo.entity.District;
import com.example.demo.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DistrictController {

    private final DistrictRepository repo;

    @PostMapping
    public District add(@RequestBody District d) {
        return repo.save(d);
    }

    @GetMapping
    public List<District> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public District update(@PathVariable String id, @RequestBody District d) {

        District existing = repo.findById(id).orElseThrow();

        existing.setName(d.getName());
        existing.setCountryId(d.getCountryId());
        existing.setCountryName(d.getCountryName());
        existing.setStateId(d.getStateId());
        existing.setStateName(d.getStateName());

        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}