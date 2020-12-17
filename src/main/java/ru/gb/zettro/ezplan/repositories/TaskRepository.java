package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.entities.task.Task;
import ru.gb.zettro.ezplan.registry.Registry;
import ru.gb.zettro.ezplan.viewdto.TaskView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskRepository implements Repository<Task> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Task task = Registry.getInstance().getIdentityMap().findTask(id);
        if (task != null) return Optional.of(task);
        TaskView view = jdbcTemplate.query(
                "select t.id, t.name, t.description, t.completed, t.weight, t.archived," +
                        " c.id, c.name, c.color," +
                        " p.id, p.name, p.value, p.color," +
                        " u.id, u.username from tasks t " +
                        " join categories c on t.categoryId = c.id" +
                        " join priorities p c on t.priorityId = p.id" +
                        " join users u on t.userId = u.id" +
                        " where id = ?",
                (r, i) -> TaskView.builder()
                        .id(r.getLong(1))
                        .name(r.getString(2))
                        .description(r.getString(3))
                        .completed(r.getBoolean(4))
                        .weight(r.getInt(5))
                        .archived(r.getBoolean(6))
                        .categoryId(r.getLong(7))
                        .categoryName(r.getString(8))
                        .categoryColor(r.getString(9))
                        .priorityId(r.getLong(10))
                        .priorityName(r.getString(11))
                        .priorityValue(r.getInt(12))
                        .priorityColor(r.getString(13))
                        .userId(r.getLong(14))
                        .username(r.getString(15))
                        .build(),
                id).stream().findAny().orElse(null);
        if (view != null) { // если не null - добавляем в кэш
            task = mapTask(view);
            // рекурсивное получение подзадач
            List<Long> subtasksIds = jdbcTemplate.query(
                    "select s.id, s.subid subtasks s where id = ?",
                    (r, i) -> r.getLong(2), id).stream().collect(Collectors.toList());
            for (Long taskId : subtasksIds) {
                Task subtask = findById(taskId).orElseThrow();
                task.addSubtask(subtask);
            }
            Registry.getInstance().getIdentityMap().addTask(task);
        }
        return Optional.of(task);
    }

    private Task mapTask(TaskView view) {
        return Task.builder()
                .id(view.getId())
                .name(view.getName())
                .description(view.getDescription())
                .completed(view.getCompleted())
                .weight(view.getWeight())
                .archived(view.getArchived())
                .category(mapCategory(view))
                .priority(mapPriority(view))
                .user(mapUser(view))
                .build();
    }


    private Category mapCategory(TaskView view) {
        return Category.builder()
                .id(view.getCategoryId())
                .name(view.getCategoryName())
                .color(view.getCategoryColor())
                .user(mapUser(view))
                .build();
    }

    private Priority mapPriority(TaskView view) {
        return Priority.builder()
                .id(view.getPriorityId())
                .name(view.getPriorityName())
                .value(view.getPriorityValue())
                .color(view.getPriorityColor())
                .user(mapUser(view))
                .build();
    }


    private User mapUser(TaskView view) {
        return User.builder()
                .id(view.getUserId())
                .username(view.getUsername())
                .build();
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
