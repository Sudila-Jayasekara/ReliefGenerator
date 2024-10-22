package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.ClassEntity;
import com.reliefgenerator.backend.entity.Period;
import com.reliefgenerator.backend.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classService.getAllClasses();
    }
    @PostMapping
    public ClassEntity saveClass(@RequestBody ClassEntity classEntity) {
        return classService.saveClass(classEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteClassById(@PathVariable Long id) {
        classService.deleteClassById(id);
    }
}
