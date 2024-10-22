package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.Attendance;
import com.reliefgenerator.backend.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    //get mappings
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public List<Long> getAbsentTeacherIds() {
        LocalDate date = LocalDate.now();
        List<Attendance> absentAttendances = attendanceRepository.findAbsentTeachersToday(date);
        List<Long> absentTeacherIds = new ArrayList<>();

        for (Attendance attendance : absentAttendances) {
            Long teacherId = attendance.getTeacher().getId();
            if (!absentTeacherIds.contains(teacherId)) { // Ensure uniqueness
                absentTeacherIds.add(teacherId);
            }
        }

        return absentTeacherIds;
    }


    public Attendance saveAttendance(Attendance attendance) {
        attendance.setDateTime(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }



}
