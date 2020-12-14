package ru.gb.zettro.ezplan.entities;

import lombok.Builder;

@Builder
public class Task extends AbstractTree {
    private static long idCounter;
    private Long id;
    private String name;
    private String description;
    private Boolean done;
    private Integer weight;
    private Boolean archived;
    private Category category;
    private Priority priority;

    public Task() {
        id = idCounter++;
        name = "";
        description = "";
        done = false;
        weight = 10;
        archived = false;
    }

    public void addSubtask(Task t) {
        addChild(t);
    }

}
