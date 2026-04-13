package com.example.demo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    private final CustomerRepository repo;
    private final Cloudinary cloudinary;

    // ✅ ADD CUSTOMER WITH IMAGE
    @PostMapping
    public Customer add(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("mobile") String mobile,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) throws Exception {

        String imageUrl = null;

        if (file != null && !file.isEmpty()) {

            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    Map.of()
            );

            imageUrl = uploadResult.get("secure_url").toString();
        }

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setMobile(mobile);
        c.setImageUrl(imageUrl);

        return repo.save(c);
    }

    // ✅ GET ALL
    @GetMapping
    public List<Customer> getAll() {
        return repo.findAll();
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}