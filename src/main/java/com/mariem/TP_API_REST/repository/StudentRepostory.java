package com.mariem.TP_API_REST.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mariem.TP_API_REST.entity.Student;

public interface StudentRepostory extends JpaRepository<Student, Long>{
    List<Student> findByName(String name);
    Page<Student> findAll(Pageable pageable);
    
}
