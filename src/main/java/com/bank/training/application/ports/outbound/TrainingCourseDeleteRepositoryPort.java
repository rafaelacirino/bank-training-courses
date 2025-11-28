package com.bank.training.application.ports.outbound;

import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;

public interface TrainingCourseDeleteRepositoryPort {

    void delete(TrainingCourseEntity entity);
}
