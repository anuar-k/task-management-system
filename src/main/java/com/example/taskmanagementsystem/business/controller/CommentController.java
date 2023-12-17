package com.example.taskmanagementsystem.business.controller;

import com.example.taskmanagementsystem.business.model.Comment;
import com.example.taskmanagementsystem.business.model.dto.CommentCreateDto;
import com.example.taskmanagementsystem.business.model.dto.CommentDto;
import com.example.taskmanagementsystem.business.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity<List<CommentDto>> getAll() {
        List<CommentDto> comments = commentService.getAll()
                .stream().map(comment -> commentService.convertToCommentDto(comment))
                .collect(Collectors.toList());
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentDto> getById(@PathVariable Long id) {
        Comment comment = commentService.getById(id);
        return ResponseEntity.ok(commentService.convertToCommentDto(comment));
    }

    @PostMapping("/add")
    public ResponseEntity<CommentDto> add(@RequestBody CommentCreateDto comment) {
        Comment createdComment = commentService.add(comment);
        return ResponseEntity.ok(commentService.convertToCommentDto(createdComment));
    }

    @PutMapping("/update")
    public ResponseEntity<CommentDto> update(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.convertToCommentDto(commentService.update(comment)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        Comment deletedComment = commentService.delete(id);
        return ResponseEntity.ok(commentService.convertToCommentDto(deletedComment));
    }
}
