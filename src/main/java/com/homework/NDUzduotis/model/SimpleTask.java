package com.homework.NDUzduotis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a simple task in the application.
 * Stores task information including title, status, and description.
 * This entity does not have user association and is accessible without authentication.
 */
@Entity
@Table(name = "simple_tasks")
@Data
@NoArgsConstructor
public class SimpleTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
}