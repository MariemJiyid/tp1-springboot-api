package com.mariem.TP_API_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mariem.TP_API_REST.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

