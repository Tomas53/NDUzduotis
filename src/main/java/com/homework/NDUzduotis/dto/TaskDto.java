package com.homework.NDUzduotis.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homework.NDUzduotis.model.Status;
import com.homework.NDUzduotis.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String title;
    private Status status;
    private String description;
}
