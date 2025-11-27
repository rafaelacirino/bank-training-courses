package com.bank.training.application.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import com.bank.training.domain.model.TrainingLevel;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO representing the input parameters for querying the applicable training course.
 * Used as input for the training-course endpoint.
 */
@Setter
@Getter
public class CreateTrainingCourseRequest {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title too long")
    @Schema(example = "Java Course", description = "Bank Training Course")
    private String title;

    @Size(max = 500, message = "Description too long")
    @Schema(example = "Course for Java development", description = "Bank Course description")
    private String description;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.01", message = "Price must be positive")
    @Schema(example = "55,20", description = "Bank Course price")
    private Double price;

    @NotNull(message = "Duration is mandatory")
    @Min(value = 1, message = "Duration must be at least 1 hour")
    @Schema(example = "40", description = "Bank Course duration")
    private Integer durationInHours;

    @NotNull(message = "Level is mandatory")
    @Schema(example = "INTERMEDIATE", description = "Bank Course level")
    private TrainingLevel level;
}
