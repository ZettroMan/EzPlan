package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.Task;

import java.util.List;
import java.util.Optional;

public class TaskRepository implements Repository<Task> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Task> findById(Integer id) {
        return null;
    }

    @Override
    public Task save(Task entity) {
        return null;
    }

    @Override
    public void update(Task entity) {

    }

    @Override
    public void delete(Task entity) {

    }

    @Override
    public List<Task> findAll() {
        return null;
    }
}
