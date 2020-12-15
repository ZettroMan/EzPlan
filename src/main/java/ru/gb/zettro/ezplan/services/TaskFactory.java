package ru.gb.zettro.ezplan.services;

import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.task.Task;
import ru.gb.zettro.ezplan.registry.Registry;

public class TaskFactory {
    public Task createDefaultTask() {
        return Task.builder()
                .name("")
                .description("")
                .completed(false)
                .weight(10)
                .archived(false)
                .user(Registry.getInstance().getCurrentUser()).build();
    }

    public Task createCustomTask(Category category, Priority priority, int weight) {
        Task task = createDefaultTask();
        task.setPriority(priority);
        task.setCategory(category);
        task.setWeight(weight);
        return task;
    }
}
