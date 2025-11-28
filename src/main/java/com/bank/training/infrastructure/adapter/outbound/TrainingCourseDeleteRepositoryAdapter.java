package com.bank.training.infrastructure.adapter.outbound;

import com.bank.training.application.ports.outbound.TrainingCourseDeleteRepositoryPort;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import com.bank.training.infrastructure.persistence.repository.TrainingCourseEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TrainingCourseDeleteRepositoryAdapter implements TrainingCourseDeleteRepositoryPort {

    private final TrainingCourseEntityRepository repository;

    @Override
    public void delete(TrainingCourseEntity entity) {
        repository.delete(entity);
    }
}
