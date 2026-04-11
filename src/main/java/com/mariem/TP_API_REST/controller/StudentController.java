package com.mariem.TP_API_REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mariem.TP_API_REST.entity.Student;
import com.mariem.TP_API_REST.repository.StudentRepostory;

import DTO.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepostory studentRepository;
    @GetMapping
    public List<Student> getAll() {
    return studentRepository.findAll();   
    }
  @PostMapping
    public Student  create(@RequestBody StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());//TODO: process POST request
        
        return studentRepository.save(student);
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
    return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    studentRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Student putMethodName(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));//TODO: process PUT request
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
        
        return studentRepository.save(student);
    }
    @GetMapping("/page")
    public Page<Student> getStudents(Pageable pageable) {
    return studentRepository.findAll(pageable);
}
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
    return studentRepository.findByName(name);
}

    


    
}
