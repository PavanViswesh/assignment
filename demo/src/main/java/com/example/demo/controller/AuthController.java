package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String signup(@RequestBody User user) {
        repo.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existing = repo.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!existing.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}