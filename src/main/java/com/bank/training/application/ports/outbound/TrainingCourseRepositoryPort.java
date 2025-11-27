package com.bank.training.application.ports.outbound;

import com.bank.training.domain.model.TrainingCourse;

public interface TrainingCourseRepositoryPort {

    TrainingCourse save(TrainingCourse trainingCourse);
}
