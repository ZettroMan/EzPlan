package ru.gb.zettro.ezplan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.dtos.TaskDto;
import ru.gb.zettro.ezplan.entities.Task;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.repositories.TaskRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private static final Function<Task, TaskDto> TaskToDto = task ->
            TaskDto.builder()
                    .id(task.getId())
                    .name(task.getName())
                    .description(task.getDescription())
                    .completed(task.isCompleted())
                    .archived(task.isArchived())
                    .categoryName(task.getCategory().getName())
                    .categoryColor(task.getCategory().getColor())
                    .priorityColor(task.getPriority().getColor())
                    .weight(task.getWeight())
                    .build();

    private final TaskRepository taskRepository;

    public List<TaskDto> findAllUserRootTasks(User user) {
        return taskRepository.findAllUserRootTasks(user).stream().map(TaskToDto).collect(Collectors.toList());
    }

}
