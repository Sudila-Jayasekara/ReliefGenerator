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
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    //get mappings
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject getSubjectByName(String name) {
        return subjectRepository.findByName(name);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}
