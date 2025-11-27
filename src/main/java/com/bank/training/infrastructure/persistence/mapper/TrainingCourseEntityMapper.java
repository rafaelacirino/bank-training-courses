package com.bank.training.infrastructure.persistence.mapper;

import com.bank.training.domain.model.TrainingCourse;
import com.bank.training.infrastructure.persistence.entity.TrainingCourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingCourseEntityMapper {

    TrainingCourse toDomain(TrainingCourseEntity entity);

    @Mapping(target = "active", constant = "true")
    @Mapping(target = "id", ignore = true)
    TrainingCourseEntity toEntity(TrainingCourse domain);
}
