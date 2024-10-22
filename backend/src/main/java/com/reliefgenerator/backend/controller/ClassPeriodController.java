package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.ClassPeriod;
import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.service.ClassPeriodService;
import com.reliefgenerator.backend.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/generate")
    public List<ClassPeriod> generateClassPeriods(){
        return classPeriodService.generateAllClassPeriods();
    }

    @PostMapping
    public ClassPeriod saveClassPeriod(@RequestBody ClassPeriod classPeriod) {
        return classPeriodService.saveClassPeriod(classPeriod);
    }
}
