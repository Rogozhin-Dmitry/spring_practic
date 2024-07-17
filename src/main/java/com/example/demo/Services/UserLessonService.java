package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLessonService {
    @Autowired
    private com.example.demo.Repositories.UserLessonsRepository userLessonsRepository;
}
