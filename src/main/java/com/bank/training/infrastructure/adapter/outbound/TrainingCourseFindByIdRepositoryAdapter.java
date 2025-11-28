package com.bank.training.infrastructure.adapter.outbound;

import com.bank.training.application.ports.outbound.TrainingCourseFindByIdRepositoryPort;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import com.bank.training.infrastructure.persistence.repository.TrainingCourseEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TrainingCourseFindByIdRepositoryAdapter implements TrainingCourseFindByIdRepositoryPort {

    private final TrainingCourseEntityRepository repository;

    @Override
    public Optional<TrainingCourseEntity> findById(Long id) {
        return repository.findById(id);
    }
}
