package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository repo;

    @PostMapping
    public Student add(@RequestBody Student student) {
        return repo.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

    // ✅ ADD THIS INSIDE CLASS
    @GetMapping("/export")
    public void exportCsv(HttpServletResponse response) throws Exception {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=students.csv");

        List<Student> students = repo.findAll();

        PrintWriter writer = response.getWriter();

        writer.println("ID,Name,Email,Mobile,Country,State,District,Gender");

        for (Student s : students) {
            writer.println(
                    s.getId() + "," +
                            s.getName() + "," +
                            s.getEmail() + "," +
                            s.getMobile() + "," +
                            s.getCountryName() + "," +
                            s.getStateName() + "," +
                            s.getDistrictName() + "," +
                            s.getGender()
            );
        }

        writer.flush();
        writer.close();
    }
    @GetMapping("/page")
    public List<Student> getPaginated(
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = repo.findAll(pageable);

        return studentPage.getContent();
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {

        Student existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // update fields
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setMobile(student.getMobile());

        existing.setCountryId(student.getCountryId());
        existing.setCountryName(student.getCountryName());

        existing.setStateId(student.getStateId());
        existing.setStateName(student.getStateName());

        existing.setDistrictId(student.getDistrictId());
        existing.setDistrictName(student.getDistrictName());

        existing.setGender(student.getGender());

        return repo.save(existing);
    }
}