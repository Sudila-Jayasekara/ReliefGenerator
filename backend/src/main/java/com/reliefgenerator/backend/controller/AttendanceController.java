package com.reliefgenerator.backend.controller;

import com.reliefgenerator.backend.entity.Attendance;
import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.service.AttendanceService;
import com.reliefgenerator.backend.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    //get mappings
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

}
