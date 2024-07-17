package com.example.demo.Controllers;

import com.example.demo.Services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MentorController {
    @Autowired
    private MentorService mentorService;
}
