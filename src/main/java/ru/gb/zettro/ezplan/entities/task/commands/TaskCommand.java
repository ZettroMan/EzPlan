package ru.gb.zettro.ezplan.entities.task.commands;

import ru.gb.zettro.ezplan.entities.task.Task;

public interface TaskCommand {
    void execute(Task task);
}
