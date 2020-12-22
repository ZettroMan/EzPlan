package ru.gb.zettro.ezplan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private boolean completed;
    private Integer weight;
    private boolean archived;
    private String categoryName;
    private String categoryColor;
    private String priorityColor;
}
