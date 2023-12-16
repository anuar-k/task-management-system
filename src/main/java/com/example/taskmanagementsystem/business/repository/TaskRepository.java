package com.example.taskmanagementsystem.business.repository;

import com.example.taskmanagementsystem.business.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, PagingAndSortingRepository<Task, Long> {
    Optional<Task> getTaskById(Long id);

    Optional<Task> removeTaskById(Long id);

}