package com.bank.training.application.ports.inbound;

import com.bank.training.application.dto.request.CreateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;

public interface CreateTrainingCourseUseCase {

    TrainingCourseResponse create(CreateTrainingCourseRequest request);
}
