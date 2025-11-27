package com.bank.training.application.dto.create;

import com.bank.training.domain.model.TrainingLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO representing the response returned by the training-course API.
 * Contains the applicable training-course details for a given product, brand, and date.
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response with training courses details")
public class CreateTrainingCourseResponse {

    @Schema(example = "1", description = "Course ID")
    private Long id;

    @Schema(example = "Clean Architecture", description = "Bank Training Course title")
    private String title;

    @Schema(example = "Advanced course...", description = "Bank Course description")
    private String description;

    @Schema(example = "55.20", description = "Bank Course price")
    private Double price;

    @Schema(example = "40", description = "Bank Course duration in hours")
    private Integer durationInHours;

    @Schema(example = "ADVANCED", description = "Bank Course level")
    private TrainingLevel level;

    @Schema(example = "true", description = "Whether the course is active")
    private Boolean active;
}
