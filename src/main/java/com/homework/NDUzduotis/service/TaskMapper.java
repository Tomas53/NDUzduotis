package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.dto.TaskDto;
import com.homework.NDUzduotis.model.Task;
import com.homework.NDUzduotis.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class TaskMapper {
    public Task dtoToEntity(TaskDto taskDto, User user) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setStatus(taskDto.getStatus());
        task.setDescription(taskDto.getDescription());
        task.setUser(user);
        return task;
    }

    public TaskDto entityToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle(task.getTitle());
        taskDto.setStatus(task.getStatus());
        taskDto.setDescription(task.getDescription());
        return taskDto;

    }
}
