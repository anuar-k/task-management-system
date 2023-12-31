package com.example.taskmanagementsystem.business.repository;

import com.example.taskmanagementsystem.business.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}