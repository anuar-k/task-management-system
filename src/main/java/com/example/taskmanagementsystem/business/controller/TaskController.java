package com.example.taskmanagementsystem.business.controller;

import com.example.taskmanagementsystem.business.model.Task;
import com.example.taskmanagementsystem.business.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/get")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Task task){
        return ResponseEntity.ok(taskService.add(task));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Task task){
        return ResponseEntity.ok(taskService.update(task));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(taskService.delete(id));
    }
}
