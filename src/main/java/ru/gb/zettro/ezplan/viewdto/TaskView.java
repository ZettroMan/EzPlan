package ru.gb.zettro.ezplan.viewdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskView {
    private Long id;
    private String name;
    private String description;
    private Boolean completed;
    private Integer weight;
    private Boolean archived;
    private Long categoryId;
    private String categoryName;
    private String categoryColor;
    private Long priorityId;
    private String priorityName;
    private Integer priorityValue;
    private String priorityColor;
    private Long userId;
    private String username;
}
