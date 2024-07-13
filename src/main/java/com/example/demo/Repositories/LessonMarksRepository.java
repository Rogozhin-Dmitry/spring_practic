package com.example.demo.Repositories;

import com.example.demo.Domain.LessonMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonMarksRepository extends JpaRepository<LessonMarks, Integer> {
}
