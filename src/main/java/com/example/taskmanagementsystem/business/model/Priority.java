package com.example.taskmanagementsystem.business.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Priority {

    private Long id;

    private String title;
}