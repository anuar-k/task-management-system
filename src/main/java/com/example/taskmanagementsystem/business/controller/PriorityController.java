package com.example.taskmanagementsystem.business.controller;

import com.example.taskmanagementsystem.business.model.Priority;
import com.example.taskmanagementsystem.business.model.dto.PriorityCreateDto;
import com.example.taskmanagementsystem.business.model.dto.PriorityDto;
import com.example.taskmanagementsystem.business.service.PriorityService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
@RequiredArgsConstructor
public class PriorityController {

    private final PriorityService priorityService;

    @GetMapping("/get")
    public ResponseEntity<List<Priority>> getAll() {
        return ResponseEntity.ok(priorityService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        return ResponseEntity.ok(priorityService.findById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody PriorityCreateDto priority) {
        return ResponseEntity.ok(priorityService.add(priorityService.convertToPriority(priority)));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {
        return ResponseEntity.ok(priorityService.update(priority));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Priority> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(priorityService.deleteById(id));
    }
}