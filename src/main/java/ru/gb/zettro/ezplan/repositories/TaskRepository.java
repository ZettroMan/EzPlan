package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.task.Task;
import ru.gb.zettro.ezplan.registry.Registry;

import java.util.List;
import java.util.Optional;

public class TaskRepository implements Repository<Task> {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Task task = Registry.getInstance().getIdentityMap().find(id);
        if (task == null) {
            task = jdbcTemplate.query(
                    "select id, name, description, completed, weight, archived, category, priority, user from tasks where id = ?",
                    (r, i) -> Task.builder()
                            .id(r.getLong(1))
                            .name(r.getString(2))
                            .completed(r.getBoolean(3))
                            .weight(r.getInt(4))
                            .archived(r.getBoolean(5))
                            // ??? Как здесь быть с категорией, приоритетом, юзером? Все делать через Id?
                            // Т.е. в классе Task нужно заменить "Category category" на "Long categoryId",
                            // "Priority priority"  на "Long priorityId" и т.д.??
                            .build(),
                    id).stream().findAny().orElse(null);
            if (task != null) { // если не null - добавляем в кэш
                Registry.getInstance().getIdentityMap().add(task);
            }
        }
        return Optional.of(task);
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
