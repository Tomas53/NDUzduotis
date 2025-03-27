package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.dto.TaskDto;
import com.homework.NDUzduotis.dto.UserDto;
import com.homework.NDUzduotis.model.Role;
import com.homework.NDUzduotis.model.Task;
import com.homework.NDUzduotis.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public static User dtoToEntity(final UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.USER);
        List<Task> task = userDto.getTasks().stream()
                .map(taskDto -> new Task(null, taskDto.getTitle(), taskDto.getStatus(), taskDto.getDescription(), user))
                .collect(Collectors.toList());
        user.setTasks(task);
        return user;
    }

    public static UserDto entityToDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        List<TaskDto> taskDtos = user.getTasks().stream()
                .map(task -> new TaskDto(task.getTitle(), task.getStatus(), task.getDescription())).toList();
        userDto.setTasks(taskDtos);
        return userDto;
    }

}
