package com.bank.training.application.service;

import com.bank.training.application.dto.request.CreateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.application.mapper.TrainingCourseMapper;
import com.bank.training.application.ports.inbound.CreateTrainingCourseUseCase;
import com.bank.training.application.ports.outbound.TrainingCourseCreateRepositoryPort;
import com.bank.training.domain.model.TrainingCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTrainingCourseService implements CreateTrainingCourseUseCase {

    private final TrainingCourseCreateRepositoryPort repository;
    private final TrainingCourseMapper mapper;

    @Override
    public TrainingCourseResponse create(CreateTrainingCourseRequest request) {
        TrainingCourse domain = mapper.toDomain(request);
        TrainingCourse saved = repository.save(domain);
        return mapper.toResponse(saved);
    }
}
