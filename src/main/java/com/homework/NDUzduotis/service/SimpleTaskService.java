package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.exception.ResourceNotFoundException;
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

    //Retrieves all tasks from the database.
    public List<SimpleTask> getAllTasks() {
        return simpleTaskRepository.findAll();
    }

    //Retrieves a task by its ID or throws an exception if not found.
    public SimpleTask getTaskById(Long id) {
        return simpleTaskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    //Finds all tasks with the specified status or throws an exception if none found.
    public List<SimpleTask> getTasksByStatus(Status status) {
        List<SimpleTask> tasks = simpleTaskRepository.findByStatus(status);

        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found with status: " + status);
        }

        return tasks;
    }

    //Creates a new task in the database.
    public SimpleTask createTask(SimpleTask task) {
        return simpleTaskRepository.save(task);
    }

    //Updates an existing task with new values.
    public SimpleTask updateTask(Long id, SimpleTask task) {
        SimpleTask existingTask = getTaskById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setStatus(task.getStatus());
        existingTask.setDescription(task.getDescription());
        return simpleTaskRepository.save(existingTask);
    }

    //Deletes a task if it exists or throws an exception if not found.
    public void deleteTask(Long id) {
        if (!simpleTaskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete task with id: " + id + " because it does not exist");
        }

        simpleTaskRepository.deleteById(id);
    }
}
