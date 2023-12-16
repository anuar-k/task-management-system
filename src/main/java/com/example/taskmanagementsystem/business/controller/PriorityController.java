package com.example.taskmanagementsystem.business.controller;

import com.example.taskmanagementsystem.business.model.Priority;
import com.example.taskmanagementsystem.business.service.PriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
        Priority priority;
        try {
            priority = priorityService.findById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priority);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Priority priority) {
        return ResponseEntity.ok(priorityService.add(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Priority priority) {
        return ResponseEntity.ok(priorityService.update(priority));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        try {
            priorityService.findById(id);
            priorityService.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}