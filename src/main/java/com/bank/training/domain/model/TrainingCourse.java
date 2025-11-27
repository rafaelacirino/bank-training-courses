package com.bank.training.domain.model;

import lombok.*;

/**
 * Domain model. Immutable via Builder.
 */
@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCourse {

    private  Long id;
    private  String title;
    private  String description;
    private  Double price;
    private  Integer durationInHours;
    private  TrainingLevel level;
    private  boolean active;
}
