package com.homework.NDUzduotis.dto;

import com.homework.NDUzduotis.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO used for transferring task data between application layers and client-side interactions.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String title;
    private Status status;
    private String description;
}
