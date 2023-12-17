package com.example.taskmanagementsystem.business.model.dto;

import com.example.taskmanagementsystem.business.model.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;

    private Long taskId;

    private String body;

    private Date createdAt;

    private Date updatedAt;
}