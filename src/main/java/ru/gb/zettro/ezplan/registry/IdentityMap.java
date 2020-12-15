package ru.gb.zettro.ezplan.registry;

import ru.gb.zettro.ezplan.entities.task.Task;

import java.util.HashMap;
import java.util.Map;

public class IdentityMap {
    private static final ThreadLocal<IdentityMap> current = new ThreadLocal<>();
    private Map<Long, Task> tasks = new HashMap<>();

    public static void init() {
        current.set(new IdentityMap());
    }

    public static IdentityMap getCurrent() {
        return current.get();
    }

    public Task find(Long id) {
        return tasks.get(id);
    }

    public void add(Task task) {
        tasks.put(task.getId(), task);
    }

    public void remove(Task task) {
        tasks.remove(task.getId(), task);
    }

    public void clear() {
        tasks.clear();
    }
}
