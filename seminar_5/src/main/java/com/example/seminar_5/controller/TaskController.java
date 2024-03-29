package com.example.seminar_5.controller;

import com.example.seminar_5.model.Task;
import com.example.seminar_5.model.TaskStatus;
import com.example.seminar_5.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setDateTime(task.getDateTime().now());
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskRepository.findAll().stream().filter(x -> x.getStatus().equals(status)).toList();
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        taskRepository.findById(id).get().setStatus(task.getStatus());
        return taskRepository.save(taskRepository.findById(id).get());
    }
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

}
