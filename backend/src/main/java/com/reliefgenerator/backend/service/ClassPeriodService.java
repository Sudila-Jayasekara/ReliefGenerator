package com.reliefgenerator.backend.service;


import com.reliefgenerator.backend.entity.*;
import com.reliefgenerator.backend.repository.ClassPeriodRepository;
import com.reliefgenerator.backend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassPeriodService {
    @Autowired
    private ClassPeriodRepository classPeriodRepository;

    @Lazy
    @Autowired
    private ClassService classService;
    @Autowired
    private PeriodService periodService;
    @Autowired
    private WeekdayService weekdayService;
    @Autowired
    private SubjectService subjectService;

    public List<ClassPeriod> getAllClassPeriods() {
        return classPeriodRepository.findAll();
    }

    public ClassPeriod saveClassPeriod(ClassPeriod classPeriod) {
        return classPeriodRepository.save(classPeriod);
    }

    public List<ClassPeriod> generateAllClassPeriods() {
        List<ClassEntity>  classes = classService.getAllClasses();
        List<Period>  periods = periodService.getAllPeriods();
        List<Weekday> weekdays = weekdayService.getAllWeekdays();

        List<ClassPeriod> newClassPeriods = new ArrayList<>();

        for(ClassEntity classEntity : classes) {
            for(Weekday weekday : weekdays) {
                for (Period period : periods) {
                    if (!classPeriodRepository.existsByClassEntityAndPeriodAndWeekday(classEntity, period, weekday)) {
                        ClassPeriod classPeriod = new ClassPeriod();
                        classPeriod.setClassEntity(classEntity);
                        classPeriod.setPeriod(period);
                        classPeriod.setWeekday(weekday);

                        newClassPeriods.add(classPeriod);
                    }
                }
            }
        }
        classPeriodRepository.saveAll(newClassPeriods);
        return newClassPeriods;
    }

    public ClassPeriod setTeacherAndSubject(ClassPeriod classPeriod, Teacher teacher, Subject subject) {
        // Check if the subject exists in the database
        Subject existingSubject = subjectService.findByName(subject.getName());
        if (existingSubject == null) {
            // If the subject does not exist, save the new subject
            existingSubject = subjectService.saveSubject(subject);
        }

        classPeriod.setTeacher(teacher);
        classPeriod.setSubject(existingSubject);

        return classPeriodRepository.save(classPeriod);
    }

}
