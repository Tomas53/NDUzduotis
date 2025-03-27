package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.model.SimpleTask;
import com.homework.NDUzduotis.model.Status;
import com.homework.NDUzduotis.repository.SimpleTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleTaskService {
    private final SimpleTaskRepository simpleTaskRepository;

    public List<SimpleTask> getAllTasks() {
        return simpleTaskRepository.findAll();
    }

    public SimpleTask getTaskById(Long id) {
        return simpleTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<SimpleTask> getTasksByStatus(Status status) {
        return simpleTaskRepository.findByStatus(status);
    }

    public SimpleTask createTask(SimpleTask task) {
        return simpleTaskRepository.save(task);
    }

    public SimpleTask updateTask(Long id, SimpleTask task) {
        SimpleTask existingTask = getTaskById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());
        existingTask.setDescription(task.getDescription());
        return simpleTaskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        simpleTaskRepository.deleteById(id);
    }
}
