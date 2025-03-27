package com.homework.NDUzduotis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//User DTO used for transferring user data between application layers and client-side interactions.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private List<TaskDto> tasks;
}
