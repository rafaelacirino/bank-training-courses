package com.bank.training.application.service;

import com.bank.training.application.dto.request.UpdateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.application.mapper.TrainingCourseMapper;
import com.bank.training.application.ports.inbound.UpdateTrainingCourseUseCase;
import com.bank.training.application.ports.outbound.TrainingCourseFindByIdRepositoryPort;
import com.bank.training.application.ports.outbound.TrainingCourseUpdateRepositoryPort;
import com.bank.training.domain.exception.ServiceException;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTrainingCourseService implements UpdateTrainingCourseUseCase {

    private final TrainingCourseFindByIdRepositoryPort findByIdRepositoryPort;
    private final TrainingCourseUpdateRepositoryPort updateRepositoryPort;
    private final TrainingCourseMapper mapper;

    @Override
    public TrainingCourseResponse update(Long id, UpdateTrainingCourseRequest request) {
        TrainingCourseEntity entity = findByIdRepositoryPort.findById(id)
                .orElseThrow(() -> new ServiceException("Course with id " + id + " not found"));

        mapper.updateEntityFromRequest(entity, request);

        TrainingCourseEntity saved = updateRepositoryPort.update(entity);
        return mapper.toResponse(saved);
    }
}
