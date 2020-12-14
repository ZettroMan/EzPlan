package ru.gb.zettro.ezplan.entities;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Priority implements Comparable<Priority> {
    private Long id;
    private String name;
    private Integer value;
    private String color;
    private User user;


    @Override
    public int compareTo(Priority o) {
        return value - o.getValue();
    }
}
