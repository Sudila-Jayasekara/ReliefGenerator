package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.Teacher;
import com.reliefgenerator.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private TeacherPeriodService teacherPeriodService;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getAbsentTeachers() {
        List<Long> absentTeacherIds = attendanceService.getAbsentTeacherIds();
        List<Teacher> absentTeachers = new ArrayList<>();

        for (Long teacherId : absentTeacherIds) {
            Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
            if (teacher != null) {
                absentTeachers.add(teacher);
            }
        }

        return absentTeachers;
    }

    public Teacher saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        teacherPeriodService.generateAllTeacherPeriods();
        return teacher;
    }
}
