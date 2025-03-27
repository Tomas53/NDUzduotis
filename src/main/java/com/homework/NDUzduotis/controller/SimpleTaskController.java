package com.homework.NDUzduotis.controller;

import com.homework.NDUzduotis.model.SimpleTask;
import com.homework.NDUzduotis.model.Status;
import com.homework.NDUzduotis.service.SimpleTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//SimpleTaskController class used for SimpleTask endpoints that don't require authentication
@RestController
@RequestMapping("/api/public/tasks")
@RequiredArgsConstructor
public class SimpleTaskController {
    private final SimpleTaskService simpleTaskService;

    @GetMapping
    public ResponseEntity<List<SimpleTask>> getAllTasks() {
        return ResponseEntity.ok(simpleTaskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimpleTask> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(simpleTaskService.getTaskById(id));
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<SimpleTask>> getTasksByStatus(@RequestParam String status) {
        return ResponseEntity.ok(simpleTaskService.getTasksByStatus(Status.valueOf(status.toUpperCase())));
    }

    @PostMapping
    public ResponseEntity<SimpleTask> createTask(@RequestBody SimpleTask simpleTask) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(simpleTaskService.createTask(simpleTask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleTask> updateTask(@PathVariable Long id, @RequestBody SimpleTask simpleTask) {
        return ResponseEntity.ok(simpleTaskService.updateTask(id, simpleTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        simpleTaskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
