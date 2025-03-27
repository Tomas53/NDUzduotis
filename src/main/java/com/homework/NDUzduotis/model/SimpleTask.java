package com.homework.NDUzduotis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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