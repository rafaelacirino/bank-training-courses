package com.bank.training.application.mapper;

import com.bank.training.application.dto.request.CreateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.domain.model.TrainingCourse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingCourseMapper {

    TrainingCourse toDomain(CreateTrainingCourseRequest request);

    TrainingCourseResponse toResponse(TrainingCourse domain);
}
