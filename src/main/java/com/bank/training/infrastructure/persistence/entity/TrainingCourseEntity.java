package com.bank.training.infrastructure.persistence.entity;

import com.bank.training.domain.model.TrainingLevel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The type Training Course entity.
 */
@Entity
@Table(name = "training_courses")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE training_courses SET active = false WHERE id = ?")
@Where(clause = "active = true")
@EntityListeners(AuditingEntityListener.class)
public class TrainingCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "duration_in_hours", nullable = false)
    private Integer durationInHours;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private TrainingLevel level;

    @Column(name = "active", nullable = false)
    private boolean active = true;
}
