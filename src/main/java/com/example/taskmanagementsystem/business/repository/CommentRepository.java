package com.example.taskmanagementsystem.business.repository;

import com.example.taskmanagementsystem.business.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, PagingAndSortingRepository<Comment, Long> {
    Optional<Comment> getPriorityById(Long id);

    Optional<Comment> removePriorityById(Long id);
}