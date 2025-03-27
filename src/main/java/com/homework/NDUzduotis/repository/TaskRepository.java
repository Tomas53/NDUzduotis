package com.homework.NDUzduotis.repository;

import com.homework.NDUzduotis.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides standard JPA operations for user-specific task management.
 * Handles tasks that are associated with users and require authentication to access.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
