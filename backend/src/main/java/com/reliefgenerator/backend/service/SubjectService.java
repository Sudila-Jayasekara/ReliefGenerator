package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.Attendance;
import com.reliefgenerator.backend.entity.Subject;
import com.reliefgenerator.backend.repository.AttendanceRepository;
import com.reliefgenerator.backend.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    //get mappings
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}
