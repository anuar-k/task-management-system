package com.example.taskmanagementsystem.business.service;

import com.example.taskmanagementsystem.business.model.Task;
import com.example.taskmanagementsystem.business.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Task with id: %d not found", id)));
    }

    public Object delete(Long id) {
        return taskRepository.removeTaskById(id).orElseThrow(() -> new RuntimeException(String.format("Task with id: %d not found", id)));
    }

    public Object update(Task task) {
        return null;
    }

    public Object add(Task task) {
        return taskRepository.save(task);
    }
}