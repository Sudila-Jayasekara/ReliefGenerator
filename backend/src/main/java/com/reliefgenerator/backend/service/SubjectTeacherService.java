package com.reliefgenerator.backend.service;

import com.reliefgenerator.backend.entity.Subject;
import com.reliefgenerator.backend.entity.SubjectTeacher;
import com.reliefgenerator.backend.repository.SubjectRepository;
import com.reliefgenerator.backend.repository.SubjectTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectTeacherService {
    @Autowired
    private SubjectTeacherRepository subjectTeacherRepository;

    //get mappings
    public List<SubjectTeacher> getAllSubjectTeachers() {
        return subjectTeacherRepository.findAll();
    }

    public SubjectTeacher saveSubjectTeacher(SubjectTeacher subjectTeacher) {
        return subjectTeacherRepository.save(subjectTeacher);
    }

}
