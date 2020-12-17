package ru.gb.zettro.ezplan.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.zettro.ezplan.entities.task.Task;

@Data
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private Boolean completed;
    private Boolean archived;
    private Integer weight;

    public TaskDto(Task t) {
        this.id = t.getId();
        this.name = t.getName();
        this.completed = t.getCompleted();
        this.archived = t.getArchived();
        this.weight = t.getWeight();
    }
}
