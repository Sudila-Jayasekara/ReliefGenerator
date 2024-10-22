package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.ClassEntity;
import com.reliefgenerator.backend.entity.ClassPeriod;
import com.reliefgenerator.backend.entity.Period;
import com.reliefgenerator.backend.entity.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassPeriodRepository extends JpaRepository<ClassPeriod, Long> {
    boolean existsByClassEntityAndPeriodAndWeekday(ClassEntity classEntity, Period period, Weekday weekday);
}
