package com.bank.training.application.ports.inbound;

import com.bank.training.application.dto.response.TrainingCourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetTrainingCoursesUseCase {

    Page<TrainingCourseResponse> findAllActive(Pageable pageable);

    TrainingCourseResponse findByIdActive(Long id);
}
