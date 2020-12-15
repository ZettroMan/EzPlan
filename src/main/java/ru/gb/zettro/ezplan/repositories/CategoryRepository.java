package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.Category;

import java.util.List;
import java.util.Optional;

public class CategoryRepository implements Repository<Category> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.of(null);
    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }


}
