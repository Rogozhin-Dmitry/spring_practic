package com.example.demo.Repositories;


import com.example.demo.Domain.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}
