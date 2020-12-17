package ru.gb.zettro.ezplan.viewdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriorityView {
    private Long id;
    private String name;
    private Integer value;
    private String color;
    private Long userId;
    private String username;

}
