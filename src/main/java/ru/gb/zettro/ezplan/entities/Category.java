package ru.gb.zettro.ezplan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String color;
    private User user;
}
