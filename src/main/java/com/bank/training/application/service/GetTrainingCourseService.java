package com.bank.training.application.service;

import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.application.mapper.TrainingCourseMapper;
import com.bank.training.application.ports.inbound.GetTrainingCoursesUseCase;
import com.bank.training.application.ports.outbound.TrainingCourseReadRepositoryPort;
import com.bank.training.domain.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTrainingCourseService implements GetTrainingCoursesUseCase {

    private final TrainingCourseReadRepositoryPort repository;
    private final TrainingCourseMapper mapper;

    @Override
    public Page<TrainingCourseResponse> findAllActive(Pageable pageable) {
        return repository.findAllActive(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public TrainingCourseResponse findByIdActive(Long id) {
        return repository.findByIdActive(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ServiceException("Course not found or inactive", HttpStatus.NOT_FOUND));
    }
}
