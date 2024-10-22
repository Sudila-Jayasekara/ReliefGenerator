package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.Teacher;
import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.service.TeacherService;
import com.reliefgenerator.backend.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/absent")
    public List<Teacher> getAbsentTeachers() {
        return teacherService.getAbsentTeachers();
    }

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

}
