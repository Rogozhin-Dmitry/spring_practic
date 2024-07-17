package com.example.demo.Controllers;

import com.example.demo.DTOs.LessonDTO;
import com.example.demo.DTOs.LessonMarksDTO;
import com.example.demo.DTOs.ThemeDTO;
import com.example.demo.Servises.firstBusinessService;
import com.example.demo.Servises.secondBusinessService;
import com.example.demo.Servises.thirdBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BusinessControllers {
    @Autowired
    private firstBusinessService firstBusinessServer;

    @Autowired
    private secondBusinessService secondBusinessService;

    @Autowired
    private thirdBusinessService thirdBusinessService;


    @GetMapping("/first/{userId}")
    public List<LessonDTO> firstBusinessGetter(@PathVariable int userId) {
        return firstBusinessServer.firstBusinessQuery(userId);
    }

    @GetMapping("/second")
    public List<ThemeDTO> secondBusinessGetter() {
        return secondBusinessService.secondBusinessQuery();
    }

        @GetMapping("/third/{lessonId}")
    public List<LessonMarksDTO> thirdBusinessGetter(@PathVariable int lessonId) {
        return thirdBusinessService.thirdBusinessQuery(lessonId);
    }
}
