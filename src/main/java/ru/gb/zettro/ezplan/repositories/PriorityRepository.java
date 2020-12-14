package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.Priority;

import java.util.List;
import java.util.Optional;

public class PriorityRepository implements Repository<Priority> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PriorityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Priority> findById(Integer id) {
        return null;
    }

    @Override
    public Priority save(Priority entity) {
        return null;
    }

    @Override
    public void update(Priority entity) {

    }

    @Override
    public void delete(Priority entity) {

    }

    @Override
    public List<Priority> findAll() {
        return null;
    }
}
