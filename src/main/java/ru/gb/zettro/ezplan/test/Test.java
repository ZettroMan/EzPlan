package ru.gb.zettro.ezplan.test;

import ru.gb.zettro.ezplan.dtos.TaskDto;
import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.Priority;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.entities.task.Task;
import ru.gb.zettro.ezplan.entities.task.commands.SetArchived;
import ru.gb.zettro.ezplan.entities.task.commands.SetCompleted;
import ru.gb.zettro.ezplan.registry.Registry;
import ru.gb.zettro.ezplan.services.TaskFactory;

public class Test {

    public static void main(String[] args) {

        User mockUser = new User(1L, "John", "100", "asd@gmail");
        SetCompleted setCompleted = new SetCompleted();
        SetArchived setArchived = new SetArchived();

        Registry registry = Registry.getInstance();
        registry.setCurrentUser(mockUser);  //
        TaskFactory taskFactory = registry.getTaskFactory();
        System.out.println("Current user name = " + registry.getCurrentUser().getUsername());

        Category mockCategory = new Category(1L, "Work", "#4fe30d", mockUser);
        Priority mockPriority = new Priority(1L, "Hot", 10, "#ff0000", mockUser);

        Task task1 = taskFactory.createCustomTask(mockCategory, mockPriority, 10);
        Task task2 = taskFactory.createCustomTask(mockCategory, mockPriority, 20);
        Task task3 = taskFactory.createCustomTask(mockCategory, mockPriority, 50);
        Task task4 = taskFactory.createCustomTask(mockCategory, mockPriority, 40);
        Task task5 = taskFactory.createCustomTask(mockCategory, mockPriority, 30);

        task1.setId(1L);
        task2.setId(2L);
        task3.setId(3L);
        task4.setId(4L);
        task5.setId(5L);
        task1.addSubtask(task2);
        task1.addSubtask(task3);
        task2.addSubtask(task4);
        task2.addSubtask(task5);
        //                                        task1
        //                task2 ------------------|   \------------ task3
        //                 / \
        //      task4 ----/   \---- task5

        System.out.println("==========================================\nAll tasks BEFORE:");
        printTasks(task1, task2, task3, task4, task5);

        task4.execute(setCompleted);
        task5.execute(setArchived);
        System.out.println("==========================================\nAll tasks AFTER:");

        printTasks(task1, task2, task3, task4, task5);
    }

    private static void printTasks(Task... tasks) {
        for (Task task : tasks) {
            System.out.print(new TaskDto(task));
            System.out.printf("      %1$.2f%% completed\n", task.getCompletePercentage());

        }
    }
}
