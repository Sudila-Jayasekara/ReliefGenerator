package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weekday")
public class WeekdayController {
    @Autowired
    private WeekdayService weekdayService;

    @GetMapping
    public List<Weekday> getAllWeekdays() {
        return weekdayService.getAllWeekdays();
    }
    @PostMapping
    public Weekday saveWeekday(@RequestBody Weekday weekday) {
        return weekdayService.saveWeekday(weekday);
    }
}
