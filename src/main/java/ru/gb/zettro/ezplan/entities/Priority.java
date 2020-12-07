package ru.gb.zettro.ezplan.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "priorities")
@Data
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
