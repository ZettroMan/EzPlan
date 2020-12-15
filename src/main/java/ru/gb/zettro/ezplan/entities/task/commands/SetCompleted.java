package ru.gb.zettro.ezplan.entities.task.commands;

import ru.gb.zettro.ezplan.entities.task.Task;

public class SetCompleted implements TaskCommand {

    @Override
    public void execute(Task task) {
        task.setCompleted(true);
    }
}
