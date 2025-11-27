package com.bank.training.application.mapper;

import com.bank.training.application.dto.create.CreateTrainingCourseRequest;
import com.bank.training.application.dto.create.CreateTrainingCourseResponse;
import com.bank.training.domain.model.TrainingCourse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TrainingCourseMapper {

    TrainingCourse toDomain(CreateTrainingCourseRequest request);

    CreateTrainingCourseResponse toResponse(TrainingCourse domain);
}
