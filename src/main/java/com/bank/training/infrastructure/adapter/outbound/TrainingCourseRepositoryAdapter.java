package com.bank.training.infrastructure.adapter.outbound;

import com.bank.training.application.ports.outbound.TrainingCourseRepositoryPort;
import com.bank.training.domain.model.TrainingCourse;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import com.bank.training.infrastructure.persistence.mapper.TrainingCourseEntityMapper;
import com.bank.training.infrastructure.persistence.repository.TrainingCourseEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter between JPA and domain.
 */
@Component
@RequiredArgsConstructor
public class TrainingCourseRepositoryAdapter implements TrainingCourseRepositoryPort {

    private final TrainingCourseEntityRepository repository;
    private final TrainingCourseEntityMapper mapper;

    @Override
    public TrainingCourse save(TrainingCourse domain) {
        TrainingCourseEntity entity = mapper.toEntity(domain);
        TrainingCourseEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }
}
