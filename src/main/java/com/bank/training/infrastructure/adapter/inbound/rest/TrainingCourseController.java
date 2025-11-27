package com.bank.training.infrastructure.adapter.inbound.rest;

import com.bank.training.application.dto.create.CreateTrainingCourseRequest;
import com.bank.training.application.dto.create.CreateTrainingCourseResponse;
import com.bank.training.application.ports.inbound.CreateTrainingCourseUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * REST controller for querying bank training courses.
 */
@RestController
@Validated
@RequestMapping("/api/training-courses")
@RequiredArgsConstructor
@Tag(name = "Training Courses", description = "Operations related to training courses")
public class TrainingCourseController {

    private final CreateTrainingCourseUseCase createUseCase;

    @PostMapping
    @Operation(summary = "createTrainingCourse", description = "Create a new Course and insert into DB")
    public ResponseEntity<CreateTrainingCourseResponse> create(@Valid @RequestBody CreateTrainingCourseRequest request,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        CreateTrainingCourseResponse response = createUseCase.create(request);

        URI location = uriComponentsBuilder
                .path("/api/training-courses/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }
}
