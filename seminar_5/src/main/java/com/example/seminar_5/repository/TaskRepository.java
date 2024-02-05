package com.example.seminar_5.repository;

import com.example.seminar_5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
