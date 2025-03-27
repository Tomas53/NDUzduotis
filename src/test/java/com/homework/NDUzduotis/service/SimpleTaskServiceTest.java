package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.model.SimpleTask;
import com.homework.NDUzduotis.model.Status;
import com.homework.NDUzduotis.repository.SimpleTaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Unit tests for the SimpleTaskService class.
@ExtendWith(MockitoExtension.class)
class SimpleTaskServiceTest {
    @Mock
    private SimpleTaskRepository repository;

    @InjectMocks
    private SimpleTaskService service;

    //Tests retrieving all tasks.
    @Test
    void testGetAllTasks() {
        SimpleTask task = new SimpleTask();
        when(repository.findAll()).thenReturn(List.of(task));
        assertEquals(1, service.getAllTasks().size());
    }

    //Tests retrieving a task by ID.
    @Test
    void testGetTaskById() {
        SimpleTask task = new SimpleTask();
        task.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(task));
        assertEquals(1L, service.getTaskById(1L).getId());
    }

    //Tests retrieving tasks by status.
    @Test
    void testGetTasksByStatus() {
        SimpleTask task = new SimpleTask();
        task.setStatus(Status.IN_PROGRESS);
        when(repository.findByStatus(Status.IN_PROGRESS)).thenReturn(List.of(task));
        assertEquals(Status.IN_PROGRESS, service.getTasksByStatus(Status.IN_PROGRESS).get(0).getStatus());
    }

    //Tests creating and updating tasks.
    @Test
    void testCreateAndUpdateTask() {
        SimpleTask task = new SimpleTask();
        when(repository.save(any())).thenReturn(task);
        assertSame(task, service.createTask(new SimpleTask()));

        task.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(task));
        SimpleTask updated = service.updateTask(1L, new SimpleTask());
        assertSame(task, updated);
    }

    //Tests deleting a task.
    @Test
    void testDeleteTask() {
        service.deleteTask(1L);
        verify(repository).deleteById(1L);
    }
}