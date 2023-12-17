package com.example.taskmanagementsystem.business.service;

import com.example.taskmanagementsystem.business.model.Comment;
import com.example.taskmanagementsystem.business.model.Task;
import com.example.taskmanagementsystem.business.model.dto.CommentCreateDto;
import com.example.taskmanagementsystem.business.model.dto.CommentDto;
import com.example.taskmanagementsystem.business.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskService taskService;

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment getById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Comment with id: %d not found", id)));
    }

    public Comment delete(Long id) {
        return commentRepository.removePriorityById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comment update(Comment comment) {
        Comment currenComment = getById(comment.getId());
        currenComment.setBody(comment.getBody());
        currenComment.setUpdatedAt(new Date(System.currentTimeMillis()));
        return commentRepository.saveAndFlush(currenComment);
    }

    public Comment add(CommentCreateDto newComment) {
        return commentRepository.save(convertToComment(newComment));
    }

    public CommentDto convertToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .taskId(comment.getTask().getId())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public Comment convertToComment(CommentCreateDto commentDto) {
        Task task = taskService.getById(commentDto.getTaskId());
        return Comment.builder()
                .body(commentDto.getBody())
                .task(task)
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
    }

    public Comment convertToComment(CommentDto commentDto) {
        Task task = taskService.getById(commentDto.getTaskId());
        return Comment.builder()
                .body(commentDto.getBody())
                .task(task)
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
    }
}