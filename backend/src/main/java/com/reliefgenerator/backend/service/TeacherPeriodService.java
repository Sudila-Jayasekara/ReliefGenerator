package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.*;
import com.reliefgenerator.backend.repository.TeacherPeriodRepository;
import com.reliefgenerator.backend.repository.WeekdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherPeriodService {
    @Autowired
    private TeacherPeriodRepository teacherPeriodRepository;

    @Lazy
    @Autowired
    private TeacherService teacherService;

    public List<TeacherPeriod> getAllTeacherPeriods() {
        return teacherPeriodRepository.findAll();
    }

    public TeacherPeriod saveTeacherPeriod(TeacherPeriod teacherPeriod) {
        return teacherPeriodRepository.save(teacherPeriod);
    }

    public void deleteAllTeacherPeriodsById(Long id) {
        List<TeacherPeriod> teacherPeriods = teacherPeriodRepository.findAll();
        for (TeacherPeriod teacherPeriod : teacherPeriods) {
            if(teacherPeriod.getTeacher().getId().equals(id)) {
                teacherPeriodRepository.delete(teacherPeriod);
            }
        }
    }

}
