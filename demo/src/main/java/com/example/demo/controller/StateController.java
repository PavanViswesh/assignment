package com.example.demo.controller;

import com.example.demo.entity.State;
import com.example.demo.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StateController {

    private final StateRepository repo;

    @PostMapping
    public State add(@RequestBody State s) {
        return repo.save(s);
    }

    @GetMapping
    public List<State> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public State update(@PathVariable String id, @RequestBody State s) {
        State existing = repo.findById(id).orElseThrow();

        existing.setName(s.getName());
        existing.setCountryId(s.getCountryId());
        existing.setCountryName(s.getCountryName());

        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
