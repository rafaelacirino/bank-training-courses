package com.bank.training.application.assembler;

import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.infrastructure.adapter.inbound.rest.TrainingCourseController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TrainingCourseModelAssembler implements
        RepresentationModelAssembler<TrainingCourseResponse, EntityModel<TrainingCourseResponse>> {

    @Override
    public EntityModel<TrainingCourseResponse> toModel(TrainingCourseResponse response) {
        return EntityModel.of(response,
                linkTo(methodOn(TrainingCourseController.class).getTrainingCourseByIdWhenActive(response.getId())).withSelfRel(),
                linkTo(methodOn(TrainingCourseController.class).getAllTrainingCourses(null)).withRel("courses"));
    }
}
