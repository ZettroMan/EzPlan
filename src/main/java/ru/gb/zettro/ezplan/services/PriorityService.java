package ru.gb.zettro.ezplan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.repositories.PriorityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriorityService {
    private final PriorityRepository priorityRepository;

    public List<Priority> findAll() {
        return priorityRepository.findAll();
    }
}
