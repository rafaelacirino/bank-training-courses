package com.bank.training.application.ports.outbound;

import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;

import java.util.Optional;

public interface TrainingCourseFindByIdRepositoryPort {

    Optional<TrainingCourseEntity> findById(Long id);
}
