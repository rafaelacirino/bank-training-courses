package com.bank.training.application.dto.request;

import com.bank.training.domain.model.TrainingLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * DTO representing the input parameters for update the applicable training course.
 * Used as input for the training-course endpoint.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request DTO for updating a training course (partial update allowed)")
public class UpdateTrainingCourseRequest {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100)
    @Schema(example = "Advanced Clean Architecture")
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 500)
    private String description;

    @Positive(message = "Price must be positive")
    @Schema(example = "2990.00")
    private Double price;

    @Positive(message = "Duration must be positive")
    @Schema(example = "40")
    private Integer durationInHours;

    @NotNull(message = "Level is mandatory")
    private TrainingLevel level;

    @Schema(description = "Set to true to reactivate an inactive course", example = "true")
    private Boolean active;
}
