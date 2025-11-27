package com.bank.training.application.service;

import com.bank.training.application.dto.create.CreateTrainingCourseRequest;
import com.bank.training.application.dto.create.CreateTrainingCourseResponse;
import com.bank.training.application.mapper.TrainingCourseMapper;
import com.bank.training.application.ports.inbound.CreateTrainingCourseUseCase;
import com.bank.training.application.ports.outbound.TrainingCourseRepositoryPort;
import com.bank.training.domain.model.TrainingCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTrainingCourseService implements CreateTrainingCourseUseCase {

    private final TrainingCourseRepositoryPort repository;
    private final TrainingCourseMapper mapper;

    @Override
    public CreateTrainingCourseResponse create(CreateTrainingCourseRequest request) {
        TrainingCourse domain = mapper.toDomain(request);
        TrainingCourse saved = repository.save(domain);
        return mapper.toResponse(saved);
    }
}
