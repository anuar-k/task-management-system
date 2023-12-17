package com.example.taskmanagementsystem.business.service;

import com.example.taskmanagementsystem.business.model.Priority;
import com.example.taskmanagementsystem.business.model.dto.PriorityCreateDto;
import com.example.taskmanagementsystem.business.repository.PriorityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public List<Priority> getAll() {
        return priorityRepository.findAll();
    }

    public Priority getById(Long id) {
        return priorityRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Priority with id: %d not found", id)));
    }

    public Priority deleteById(Long id) {
        Priority priority = getById(id);
        priorityRepository.deleteById(priority.getId());
        return priority;
    }

    public Priority update(Priority priority) {
        Priority currentPriority = findById(priority.getId());
        currentPriority.setTitle(priority.getTitle());
        return priorityRepository.save(currentPriority);
    }

    public Priority add(Priority priority) {
        return priorityRepository.save(priority);
    }

    public Priority findById(Long id) {
        return priorityRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("приоритет с id: %d не найден", id)));
    }

    public Priority convertToPriority(PriorityCreateDto priorityCreateDto) {
        return Priority.builder()
                .title(priorityCreateDto.getTitle())
                .build();
    }
}