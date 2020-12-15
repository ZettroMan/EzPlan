package ru.gb.zettro.ezplan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.repositories.PriorityRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriorityService {
    private final PriorityRepository priorityRepository;

    public List<Priority> findAll() {
        return priorityRepository.findAll();
    }

    public Optional<Priority> findById(Long id) {
        return priorityRepository.findById(id);
    }

    public Priority saveOrUpdate(Priority priority) {
        return priorityRepository.save(priority);
    }

}
