package com.bank.training.application.ports.outbound;

import com.bank.training.domain.model.TrainingCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TrainingCourseReadRepositoryPort {

    Page<TrainingCourse> findAllActive(Pageable pageable);

    Optional<TrainingCourse> findByIdActive(Long id);
}
