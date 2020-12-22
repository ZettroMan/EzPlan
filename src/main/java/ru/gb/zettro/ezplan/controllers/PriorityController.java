package ru.gb.zettro.ezplan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.zettro.ezplan.dtos.PriorityDto;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.exceptions.ResourceNotFoundException;
import ru.gb.zettro.ezplan.services.PriorityService;
import ru.gb.zettro.ezplan.services.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/priorities")
@RequiredArgsConstructor
public class PriorityController {
    private final PriorityService priorityService;
    private final UserService userService;

    @GetMapping(produces = "application/json")
    public List<PriorityDto> getAllPriorities(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Unable to find current user"));
        return priorityService.findAll();
    }
}
