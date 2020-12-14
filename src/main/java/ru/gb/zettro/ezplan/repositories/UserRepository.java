package ru.gb.zettro.ezplan.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.User;

import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jdbcTemplate.query(
                "select id, username where id = ?",
                (r, i) -> User.builder()
                        .id(r.getLong(1))
                        .username(r.getString(2))
                        .build(),
                id).stream().findAny();
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public Optional<User> findByUsername(String username) {
        return jdbcTemplate.query(
                "select id, username where username = ?",
                (r, i) -> User.builder()
                        .id(r.getLong(1))
                        .username(r.getString(2))
                        .build(),
                username).stream().findAny();
    }
}
