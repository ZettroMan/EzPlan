package ru.gb.zettro.ezplan.registry;

import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.task.Task;

import java.util.HashMap;
import java.util.Map;

public class IdentityMap {
    private static final ThreadLocal<IdentityMap> current = new ThreadLocal<>();
    private Map<Long, Task> tasks = new HashMap<>();
    private Map<Long, Category> categories = new HashMap<>();
    private Map<Long, Priority> priorities = new HashMap<>();

    public static void init() {
        current.set(new IdentityMap());
    }

    public static IdentityMap getCurrent() {
        return current.get();
    }

    public Task findTask(Long id) {
        return tasks.get(id);
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void removeTask(Task task) {
        tasks.remove(task.getId(), task);
    }

    public void clearTasks() {
        tasks.clear();
    }

    public Category findCategory(Long id) {
        return categories.get(id);
    }

    public void addCategory(Category category) {
        categories.put(category.getId(), category);
    }

    public void removeCategory(Category category) {
        categories.remove(category.getId(), category);
    }

    public Priority findPriority(Long id) {
        return priorities.get(id);
    }

    public void addPriority(Priority priority) {
        priorities.put(priority.getId(), priority);
    }

    public void removePriority(Priority priority) {
        priorities.remove(priority.getId(), priority);
    }
}
