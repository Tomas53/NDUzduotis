package com.homework.NDUzduotis.repository;

import com.homework.NDUzduotis.model.SimpleTask;
import com.homework.NDUzduotis.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleTaskRepository extends JpaRepository<SimpleTask, Long> {
    List<SimpleTask> findByStatus(Status status);
}
