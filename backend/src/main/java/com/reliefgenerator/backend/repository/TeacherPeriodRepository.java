package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.ClassPeriod;
import com.reliefgenerator.backend.entity.TeacherPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPeriodRepository extends JpaRepository<TeacherPeriod, Long> {

}
