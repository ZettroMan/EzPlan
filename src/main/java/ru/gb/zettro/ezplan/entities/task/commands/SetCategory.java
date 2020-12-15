package ru.gb.zettro.ezplan.entities.task.commands;

import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.task.Task;

public class SetCategory implements TaskCommand {
    Category category;

    public SetCategory(Category category) {
        this.category = category;
    }

    @Override
    public void execute(Task task) {
        task.setCategory(category);
    }
}
