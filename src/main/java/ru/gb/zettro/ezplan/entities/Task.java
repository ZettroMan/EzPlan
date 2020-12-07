package ru.gb.zettro.ezplan.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private boolean done;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "archived")
    private boolean archived;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

//    @OneToMany
//    @Column(name = "parent_id")
//    private Task parent;
}
