package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.registry.Registry;
import ru.gb.zettro.ezplan.viewdto.PriorityView;

import java.util.List;
import java.util.Optional;

public class PriorityRepository implements Repository<Priority> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PriorityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Priority> findById(Long id) {
        Priority priority = Registry.getInstance().getIdentityMap().findPriority(id);
        if (priority != null) return Optional.of(priority);
        PriorityView view = jdbcTemplate.query(
                "select p.id, p.name, p.value, p.color, u.id, u.username" +
                        " from priorities p " +
                        " join users u on p.userId = u.id " +
                        " where p.id = ?",
                (r, i) -> PriorityView.builder()
                        .id(r.getLong(1))
                        .name(r.getString(2))
                        .value(r.getInt(3))
                        .color(r.getString(4))
                        .userId(r.getLong(5))
                        .username(r.getString(6))
                        .build(),
                id
        ).stream().findAny().orElse(null);
        if (view != null) { // если не null - добавляем в кэш
            priority = mapPriority(view);
            Registry.getInstance().getIdentityMap().addPriority(priority);
        }
        return Optional.of(priority);
    }

    private Priority mapPriority(PriorityView view) {
        return Priority.builder()
                .id(view.getId())
                .name(view.getName())
                .value(view.getValue())
                .color(view.getColor())
                .user(mapUser(view))
                .build();
    }

    private User mapUser(PriorityView view) {
        return User.builder()
                .id(view.getUserId())
                .username(view.getUsername())
                .build();
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
