package com.bank.training.application.mapper;

import com.bank.training.application.dto.request.CreateTrainingCourseRequest;
import com.bank.training.application.dto.request.UpdateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.domain.model.TrainingCourse;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TrainingCourseMapper {

    TrainingCourse toDomain(CreateTrainingCourseRequest request);

    TrainingCourseResponse toResponse(TrainingCourse domain);

    TrainingCourseResponse toResponse(TrainingCourseEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void updateEntityFromRequest(@MappingTarget TrainingCourseEntity entity, UpdateTrainingCourseRequest request);
}
