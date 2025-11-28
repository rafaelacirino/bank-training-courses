package com.bank.training.infrastructure.persistence.repository;

import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCourseEntityRepository extends JpaRepository<TrainingCourseEntity, Long> {
}
