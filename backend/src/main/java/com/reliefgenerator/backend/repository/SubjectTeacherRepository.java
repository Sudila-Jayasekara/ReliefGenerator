package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.SubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher, Long> {

}
