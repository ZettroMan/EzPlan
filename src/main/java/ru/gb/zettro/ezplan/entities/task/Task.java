package ru.gb.zettro.ezplan.entities.task;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.entities.task.commands.TaskCommand;


@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Task extends AbstractTree {
    private Long id;
    private String name;
    private String description;
    private Boolean completed;
    private Integer weight;
    private Boolean archived;
    private Category category;
    private Priority priority;
    private User user;

    public void addSubtask(Task subtask) {
        addChild(subtask);
    }

    public boolean removeSubtask(Task subtask) {
        return removeChild(subtask);
    }

    public double getCompletePercentage() {
        double result = 0.0;
        int childrenTotalWeight = 0;

        if (archived) return completed ? 100.0 : 0.0;
        if (completed) return 100.0;
        if (isLeaf()) return 0.0;

        for (AbstractTree child : getChildren()) {
            Task subtask = (Task) child;
            if (subtask.archived) continue;
            childrenTotalWeight += subtask.weight;
            result += subtask.weight * subtask.getCompletePercentage();
        }
        if (childrenTotalWeight == 0) return 100.0;
        return result / childrenTotalWeight;
    }

    public void execute(TaskCommand command) {
        command.execute(this);
        for (AbstractTree child : getChildren()) {
            Task subtask = (Task) child;
            subtask.execute(command);
        }
    }


}
