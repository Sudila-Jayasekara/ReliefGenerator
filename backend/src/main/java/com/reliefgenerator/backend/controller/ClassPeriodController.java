package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.ClassPeriod;
import com.reliefgenerator.backend.entity.Subject;
import com.reliefgenerator.backend.entity.Teacher;
import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.service.ClassPeriodService;
import com.reliefgenerator.backend.service.ClassService;
import com.reliefgenerator.backend.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-period")
public class ClassPeriodController {
    @Autowired
    private ClassPeriodService classPeriodService;

    @GetMapping
    public List<ClassPeriod> getAllClassPeriods() {
        return classPeriodService.getAllClassPeriods();
    }

    @PostMapping
    public ClassPeriod saveClassPeriod(@RequestBody ClassPeriod classPeriod) {
        return classPeriodService.saveClassPeriod(classPeriod);
    }

    @PutMapping("/{id}/teacher")
    public ResponseEntity<ClassPeriod> setTeacher( @PathVariable Long id, @RequestBody Teacher teacher) {
        try {
            ClassPeriod updatedClassPeriod = classPeriodService.setTeacher(id, teacher);
            return ResponseEntity.ok(updatedClassPeriod);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}/subject")
    public ResponseEntity<ClassPeriod> setSubject( @PathVariable Long id, @RequestBody Subject subject) {
        try {
            ClassPeriod updatedClassPeriod = classPeriodService.setSubject(id, subject);
            return ResponseEntity.ok(updatedClassPeriod);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
