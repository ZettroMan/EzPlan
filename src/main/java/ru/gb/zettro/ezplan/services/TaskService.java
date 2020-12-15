package ru.gb.zettro.ezplan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.entities.task.Task;
import ru.gb.zettro.ezplan.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveOrUpdate(Task task) {
        return taskRepository.save(task);
    }


}
