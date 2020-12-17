package ru.gb.zettro.ezplan.viewdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryView {
    private Long id;
    private String name;
    private String color;
    private Long userId;
    private String username;
}
