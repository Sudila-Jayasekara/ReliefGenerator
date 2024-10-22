package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.Period;
import com.reliefgenerator.backend.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/period")
public class PeriodController {
    @Autowired
    private PeriodService periodService;

    @GetMapping
    public List<Period> getAllPeriods() {
        return periodService.getAllPeriods();
    }
    @PostMapping
    public Period savePeriod(@RequestBody Period period) {
        return periodService.savePeriod(period);
    }
}
