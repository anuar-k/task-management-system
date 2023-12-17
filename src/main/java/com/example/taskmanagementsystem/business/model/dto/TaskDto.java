package com.example.taskmanagementsystem.business.model.dto;

import com.example.taskmanagementsystem.business.model.Comment;
import com.example.taskmanagementsystem.business.model.Priority;
import com.example.taskmanagementsystem.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private String title;

    private Priority priority;

    private String description;

    private String status;

    private Date createdAt;

    private List<Comment> comments;

    private User executor;
}