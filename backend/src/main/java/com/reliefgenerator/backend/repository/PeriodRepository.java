package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

}
