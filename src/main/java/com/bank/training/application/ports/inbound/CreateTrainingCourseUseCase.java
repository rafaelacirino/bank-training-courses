package com.bank.training.application.ports.inbound;

import com.bank.training.application.dto.create.CreateTrainingCourseRequest;
import com.bank.training.application.dto.create.CreateTrainingCourseResponse;

public interface CreateTrainingCourseUseCase {

    CreateTrainingCourseResponse create(CreateTrainingCourseRequest request);
}
