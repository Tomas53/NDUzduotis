package com.homework.NDUzduotis.controller;

import com.homework.NDUzduotis.dto.TaskDto;
import com.homework.NDUzduotis.model.Task;
import com.homework.NDUzduotis.service.TaskMapper;
import com.homework.NDUzduotis.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    public ResponseEntity<?> getTasksByUserId() {
        return ResponseEntity.ok(taskService.getTasksByUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping(params = "status")
    public ResponseEntity<?> getTasksByStatus(@RequestParam String status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTaskById(id, taskDto));
    }

    @PostMapping()
    public ResponseEntity<TaskDto> addTaskByUserId(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.createTaskByUser(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
}
