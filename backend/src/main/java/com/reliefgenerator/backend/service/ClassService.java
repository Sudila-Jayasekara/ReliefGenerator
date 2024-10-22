package com.reliefgenerator.backend.service;


import com.reliefgenerator.backend.entity.ClassEntity;
import com.reliefgenerator.backend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll().stream()
                .sorted(Comparator.comparing(ClassEntity::getGrade)
                        .thenComparing(ClassEntity::getClassLetter))
                .collect(Collectors.toList());
    }

    public ClassEntity saveClass(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }
}
