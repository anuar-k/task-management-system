package com.example.taskmanagementsystem.business.service;

import com.example.taskmanagementsystem.business.model.Priority;
import com.example.taskmanagementsystem.business.repository.PriorityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void delete(Long id) {
        priorityRepository.deleteAllById(id).orElseThrow(() -> new RuntimeException("Priority not found"));
    }

    public Object update(Priority priority) {
        Priority currentPriority = findById(priority.getId());
        currentPriority.setTitle(priority.getTitle());
        return priorityRepository.save(currentPriority);
    }

    public Object add(Priority priority) {
        return priorityRepository.saveAndFlush(priority);
    }

    public Priority findById(Long id) {
        return priorityRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        priorityRepository.deleteById(id);
    }

}