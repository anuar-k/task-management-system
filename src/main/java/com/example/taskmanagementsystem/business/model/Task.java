package com.example.taskmanagementsystem.business.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Priority priority;

    private String description;

    private String status;
}