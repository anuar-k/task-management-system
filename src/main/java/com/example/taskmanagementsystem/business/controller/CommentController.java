package com.example.taskmanagementsystem.business.controller;

import com.example.taskmanagementsystem.business.model.Comment;
import com.example.taskmanagementsystem.business.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.add(comment));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.update(comment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(commentService.delete(id));
    }
}
