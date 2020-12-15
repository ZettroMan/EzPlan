package ru.gb.zettro.ezplan.entities.task.commands;

import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.task.Task;

public class SetPriority implements TaskCommand {
    Priority priority;

    public SetPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void execute(Task task) {
        task.setPriority(priority);
    }
}
