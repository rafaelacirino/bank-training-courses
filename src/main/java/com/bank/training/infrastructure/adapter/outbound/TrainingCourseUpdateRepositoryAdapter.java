package com.bank.training.infrastructure.adapter.outbound;

import com.bank.training.application.ports.outbound.TrainingCourseUpdateRepositoryPort;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import com.bank.training.infrastructure.persistence.repository.TrainingCourseEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TrainingCourseUpdateRepositoryAdapter implements TrainingCourseUpdateRepositoryPort {

    private final TrainingCourseEntityRepository repository;

    @Override
    public TrainingCourseEntity update(TrainingCourseEntity entity) {
        return repository.save(entity);
    }
}
