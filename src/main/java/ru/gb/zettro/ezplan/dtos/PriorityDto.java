package ru.gb.zettro.ezplan.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriorityDto {
    private Long id;
    private String name;
    private Integer value;
    private String color;
}
