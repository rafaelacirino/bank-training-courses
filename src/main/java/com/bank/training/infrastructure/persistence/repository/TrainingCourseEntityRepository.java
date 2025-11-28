package com.bank.training.infrastructure.persistence.repository;

import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingCourseEntityRepository extends JpaRepository<TrainingCourseEntity, Long> {

    @Query("SELECT t FROM TrainingCourseEntity t WHERE t.active = true")
    Page<TrainingCourseEntity> findAllActive(Pageable pageable);

    @Query("SELECT t FROM TrainingCourseEntity t WHERE t.id = :id AND t.active = true")
    Optional<TrainingCourseEntity> findByIdActive(@Param("id") Long id);

    @Query("SELECT t FROM TrainingCourseEntity t WHERE t.id = :id")
    Optional<TrainingCourseEntity> findByIdAny(@Param("id") Long id);
}
