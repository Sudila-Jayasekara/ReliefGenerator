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

    public ClassPeriod getClassPeriodById(Long id) {
        return classPeriodRepository.findById(id).orElse(null);
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

    public void  deleteAllClassPeriodsById(Long id) {
        List<ClassEntity>  classes = classService.getAllClasses();
        for(ClassEntity classEntity : classes) {
            if(classEntity.getId().equals(id)) {
                classPeriodRepository.deleteById(classEntity.getId());
            }
        }
    }


    public ClassPeriod setTeacher(Long classPeriodId, Teacher teacher) {
        ClassPeriod existingClassPeriod = getClassPeriodById(classPeriodId);
        if (existingClassPeriod != null) {
            existingClassPeriod.setTeacher(teacher);
            return saveClassPeriod(existingClassPeriod);
        } else {
            throw new IllegalArgumentException("ClassPeriod not found");
        }
    }

    public ClassPeriod setSubject(Long classPeriodId, Subject subject) {
        ClassPeriod existingClassPeriod = getClassPeriodById(classPeriodId);
        if (existingClassPeriod != null) {
            Subject existingSubject = subjectService.getSubjectByName(subject.getName());
            if (existingSubject == null) {
                existingSubject = subjectService.saveSubject(subject);
            }
            existingClassPeriod.setSubject(existingSubject);
            return saveClassPeriod(existingClassPeriod);
        } else {
            throw new IllegalArgumentException("ClassPeriod not found");
        }
    }


}
