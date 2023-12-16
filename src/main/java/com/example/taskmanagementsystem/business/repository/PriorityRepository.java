package com.example.taskmanagementsystem.business.repository;

import com.example.taskmanagementsystem.business.model.Priority;
import com.example.taskmanagementsystem.business.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Optional<Task> deleteAllById(Long id);

}