package com.example.demo.Controllers;

import com.example.demo.Services.UserLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLessonController {
    @Autowired
    private UserLessonService userLessonService;
}
