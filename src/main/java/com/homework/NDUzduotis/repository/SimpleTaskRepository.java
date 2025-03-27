package com.homework.NDUzduotis.repository;

import com.homework.NDUzduotis.model.SimpleTask;
import com.homework.NDUzduotis.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides standard JPA operations and custom query methods for SimpleTask management.
 * This repository handles tasks that don't require user authentication.
 */
@Repository
public interface SimpleTaskRepository extends JpaRepository<SimpleTask, Long> {
    List<SimpleTask> findByStatus(Status status);
}
