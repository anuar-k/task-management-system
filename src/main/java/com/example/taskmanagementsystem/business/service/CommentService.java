package com.example.taskmanagementsystem.business.service;

import com.example.taskmanagementsystem.business.model.Comment;
import com.example.taskmanagementsystem.business.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment getById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Comment with id: %d not found", id)));
    }

    public Object delete(Long id) {
        return commentRepository.removePriorityById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Object update(Comment comment) {
        return null;
    }

    public Object add(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }
}