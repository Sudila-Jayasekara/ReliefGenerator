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
    @Autowired
    private PeriodService periodService;
    @Autowired
    private WeekdayService weekdayService;

    public List<TeacherPeriod> getAllTeacherPeriods() {
        return teacherPeriodRepository.findAll();
    }

    public TeacherPeriod saveTeacherPeriod(TeacherPeriod teacherPeriod) {
        return teacherPeriodRepository.save(teacherPeriod);
    }

    public List<TeacherPeriod> generateAllTeacherPeriods(){
        List<Teacher> teachers = teacherService.getAllTeachers();
        List<Weekday> weekdays = weekdayService.getAllWeekdays();
        List<Period> periods = periodService.getAllPeriods();

        List<TeacherPeriod> teacherPeriods = new ArrayList<>();

        for (Teacher teacher : teachers) {
            for (Weekday weekday : weekdays) {
                for (Period period : periods) {
                    if(!teacherPeriodRepository.existsByTeacherAndPeriodAndWeekday(teacher, period, weekday)) {
                        TeacherPeriod teacherPeriod = new TeacherPeriod();
                        teacherPeriod.setTeacher(teacher);
                        teacherPeriod.setWeekday(weekday);
                        teacherPeriod.setPeriod(period);
                        teacherPeriod.setIs_free(true);

                        teacherPeriods.add(teacherPeriod);
                    }
                }
            }
        }
        teacherPeriodRepository.saveAll(teacherPeriods);
        return teacherPeriods;
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
