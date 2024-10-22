package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.TeacherPeriod;
import com.reliefgenerator.backend.entity.Weekday;
import com.reliefgenerator.backend.repository.TeacherPeriodRepository;
import com.reliefgenerator.backend.repository.WeekdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherPeriodService {
    @Autowired
    private TeacherPeriodRepository teacherPeriodRepository;

    public List<TeacherPeriod> getAllTeacherPeriods() {
        return teacherPeriodRepository.findAll();
    }

    public TeacherPeriod saveTeacherPeriod(TeacherPeriod teacherPeriod) {
        return teacherPeriodRepository.save(teacherPeriod);
    }
}
