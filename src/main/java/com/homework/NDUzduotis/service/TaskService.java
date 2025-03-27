package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.dto.TaskDto;
import com.homework.NDUzduotis.model.Status;
import com.homework.NDUzduotis.model.Task;
import com.homework.NDUzduotis.model.User;
import com.homework.NDUzduotis.repository.UserRepository;
import com.homework.NDUzduotis.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    //Retrieves all tasks for the currently authenticated user.
    public List<TaskDto> getTasksByUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getUsername().equals(currentUsername)) {
            throw new AccessDeniedException("You can only view your own tasks");
        }

        return UserMapper.entityToDto(user).getTasks();
    }

    //Creates a new task for the currently authenticated user.
    public TaskDto createTaskByUser(TaskDto taskDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = taskMapper.dtoToEntity(taskDto, user);

        return taskMapper.entityToDto(taskRepository.save(task));
    }

    //Retrieves a specific task by ID if it belongs to the current user.
    public Optional<TaskDto> getTaskById(Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUser().getUsername().equals(currentUsername)) {
            throw new AccessDeniedException("You can only view your own tasks");
        }
        return Optional.of(taskMapper.entityToDto(task));
    }

    //Retrieves all tasks with a specific status for the current user.
    public Optional<List<TaskDto>> getTasksByStatus(String status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User user = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getUsername().equals(currentUsername)) {
            throw new AccessDeniedException("You can only view your own tasks");
        }
        Status enumStatus;
        try {
            enumStatus = Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + status);
        }

        List<TaskDto> filteredTasks = UserMapper.entityToDto(user).getTasks()
                .stream()
                .filter(task -> task.getStatus() == enumStatus)
                .collect(Collectors.toList());

        return Optional.of(filteredTasks);
    }

    //Updates a task if it belongs to the current user.
    public Optional<TaskDto> updateTaskById(Long id, TaskDto taskDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (!task.getUser().getUsername().equals(username)) {
            throw new AccessDeniedException("You can only view your own tasks");
        }
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());

        task = taskRepository.save(task);

        return Optional.of(taskMapper.entityToDto(task));
    }
}
