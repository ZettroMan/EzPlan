package ru.gb.zettro.ezplan.registry;

import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.services.TaskFactory;

public class Registry {
    private static volatile Registry instance;
    private TaskFactory taskFactory = new TaskFactory();
    private IdentityMap identityMap = IdentityMap.getCurrent();
    private User currentUser;

    private Registry() {
    }

    public static Registry getInstance() {
        if (instance == null) {
            synchronized (Registry.class) {
                if (instance == null) {
                    instance = new Registry();
                }
            }
        }
        return instance;
    }

    public TaskFactory getTaskFactory() {
        return taskFactory;
    }

    public IdentityMap getIdentityMap() {
        return identityMap;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

}
