package ru.gb.zettro.ezplan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.zettro.ezplan.dtos.TaskDto;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.exceptions.ResourceNotFoundException;
import ru.gb.zettro.ezplan.services.TaskService;
import ru.gb.zettro.ezplan.services.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @GetMapping(produces = "application/json")
    public List<TaskDto> getAllRootTasks(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Unable to find current user"));
        return taskService.findAllUserRootTasks(currentUser);
    }
}
