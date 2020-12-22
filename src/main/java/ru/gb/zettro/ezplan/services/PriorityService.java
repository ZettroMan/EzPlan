package ru.gb.zettro.ezplan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.dtos.PriorityDto;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.repositories.PriorityRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriorityService {

    private static final Function<Priority, PriorityDto> PriorityToDto = priority -> {
        return new PriorityDto().builder()
                .id(priority.getId())
                .name(priority.getName())
                .value(priority.getValue())
                .color(priority.getColor())
                .build();
    };

    private final PriorityRepository priorityRepository;

    public List<PriorityDto> findAll() {
        return priorityRepository.findAll().stream().map(PriorityToDto).collect(Collectors.toList());
    }
}
