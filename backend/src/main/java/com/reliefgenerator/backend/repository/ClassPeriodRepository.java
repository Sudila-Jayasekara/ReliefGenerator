package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.ClassPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassPeriodRepository extends JpaRepository<ClassPeriod, Long> {

}
