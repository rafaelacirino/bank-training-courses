package com.bank.training.application.service;

import com.bank.training.application.ports.inbound.DeleteTrainingCourseUseCase;
import com.bank.training.application.ports.outbound.TrainingCourseDeleteRepositoryPort;
import com.bank.training.application.ports.outbound.TrainingCourseFindByIdRepositoryPort;
import com.bank.training.domain.exception.ServiceException;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteTrainingCourseService implements DeleteTrainingCourseUseCase {

    private final TrainingCourseFindByIdRepositoryPort findByIdPort;
    private final TrainingCourseDeleteRepositoryPort deleteRepositoryPort;

    @Override
    public void deleteById(Long id) {
        TrainingCourseEntity entity = findByIdPort.findById(id)
                .orElseThrow(() -> new ServiceException("Course with id " + id + " not found"));
        deleteRepositoryPort.delete(entity);
    }
}
