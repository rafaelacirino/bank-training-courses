package com.bank.training.infrastructure.adapter.inbound.rest;

import com.bank.training.application.dto.request.CreateTrainingCourseRequest;
import com.bank.training.application.dto.request.UpdateTrainingCourseRequest;
import com.bank.training.application.dto.response.TrainingCourseResponse;
import com.bank.training.application.ports.inbound.CreateTrainingCourseUseCase;
import com.bank.training.application.ports.inbound.DeleteTrainingCourseUseCase;
import com.bank.training.application.ports.inbound.GetTrainingCoursesUseCase;
import com.bank.training.application.ports.inbound.UpdateTrainingCourseUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * REST controller for querying bank training courses.
 */
@RestController
@Validated
@RequestMapping("/api/training-courses")
@RequiredArgsConstructor
@Tag(name = "Training Courses", description = "Management of internal training programs")
public class TrainingCourseController {

    private final CreateTrainingCourseUseCase createUseCase;
    private final GetTrainingCoursesUseCase getUseCase;
    private final UpdateTrainingCourseUseCase updateUseCase;
    private final DeleteTrainingCourseUseCase deleteUseCase;

    @PostMapping
    @Operation(summary = "Create a Bank Training Course", description = "Create a new Course and insert into DB")
    public ResponseEntity<TrainingCourseResponse> create(@Valid @RequestBody CreateTrainingCourseRequest request,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        TrainingCourseResponse response = createUseCase.create(request);

        URI location = uriComponentsBuilder
                .path("/api/training-courses/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    @Operation(summary = "List active training courses",
            description = "Returns paginated list of active courses. Inactive courses are excluded via soft-delete.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active courses"),
            @ApiResponse(responseCode = "400", description = "Invalid pagination or sorting parameters")})
    @Parameter(name = "page", description = "Page number (0-based)", example = "0")
    @Parameter(name = "size", description = "Page size (max 100)", example = "10")
    @Parameter(name = "sort", description = "Sorting criteria (e.g. price,desc or title,asc)", example = "price,desc")
    public ResponseEntity<Page<TrainingCourseResponse>> getAllTrainingCourses(Pageable pageable) {
        return ResponseEntity.ok(getUseCase.findAllActive(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a course when its status is active", description = "Retrieve an active course by ID")
    public ResponseEntity<TrainingCourseResponse> getTrainingCourseByIdWhenActive(
            @PathVariable Long id) {
        return ResponseEntity.ok(getUseCase.findByIdActive(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a training course (active or inactive course)",
            description = "Updates course data. If 'active: true' is sent, reactivates an inactive course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course updated successfully (may be reactivated)"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Course not found")})
    public ResponseEntity<TrainingCourseResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTrainingCourseRequest request) {
        TrainingCourseResponse update = updateUseCase.update(id, request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Soft-delete a training course",
            description = "Marks a course as inactive. Works on both active and inactive courses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Course soft-deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Course not found")})
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        deleteUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
