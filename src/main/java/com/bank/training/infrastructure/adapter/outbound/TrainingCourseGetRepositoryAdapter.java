package com.bank.training.infrastructure.adapter.outbound;

import com.bank.training.application.ports.outbound.TrainingCourseReadRepositoryPort;
import com.bank.training.domain.model.TrainingCourse;
import com.bank.training.infrastructure.persistence.mapper.TrainingCourseEntityMapper;
import com.bank.training.infrastructure.persistence.repository.TrainingCourseEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The type Training course get repository adapter.
 */
@Component
@RequiredArgsConstructor
public class TrainingCourseGetRepositoryAdapter implements TrainingCourseReadRepositoryPort {

    private final TrainingCourseEntityRepository repository;
    private final TrainingCourseEntityMapper mapper;

    /**
     * @param pageable
     * @return all training course when the course is active
     */
    @Override
    public Page<TrainingCourse> findAllActive(Pageable pageable) {
        return repository.findAllActive(pageable).map(mapper::toDomain);
    }

    /**
     * @param id
     * @return training course when the course is active
     */
    @Override
    public Optional<TrainingCourse> findByIdActive(Long id) {
        return repository.findByIdActive(id).map(mapper::toDomain);
    }
}
