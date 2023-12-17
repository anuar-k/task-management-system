package com.example.taskmanagementsystem.business.service;

import com.example.taskmanagementsystem.business.model.Task;
import com.example.taskmanagementsystem.business.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Задача с id: %d не найдена", id)));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Object update(Task task) {
        return null;
    }

    public Object add(Task task) {
        return taskRepository.save(task);
    }
}