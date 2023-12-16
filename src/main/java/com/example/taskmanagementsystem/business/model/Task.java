package com.example.taskmanagementsystem.business.model;

import com.example.taskmanagementsystem.security.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name="priority_id", nullable=false)
    private Priority priority;

    private String description;

    private String status;

    private Date createdAt;

    @OneToMany(mappedBy="task")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;
}