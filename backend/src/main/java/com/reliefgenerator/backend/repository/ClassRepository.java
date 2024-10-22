package com.reliefgenerator.backend.repository;

import com.reliefgenerator.backend.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

}
