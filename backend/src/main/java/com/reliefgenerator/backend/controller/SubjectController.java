package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.ClassEntity;
import com.reliefgenerator.backend.entity.Subject;
import com.reliefgenerator.backend.service.ClassService;
import com.reliefgenerator.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Subject saveClass(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }
}
