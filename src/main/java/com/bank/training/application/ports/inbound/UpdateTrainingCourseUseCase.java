package com.bank.training.application.ports.inbound;

import com.bank.training.application.dto.request.UpdateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;

public interface UpdateTrainingCourseUseCase {

    TrainingCourseResponse update(Long id, UpdateTrainingCourseRequest request);
}
