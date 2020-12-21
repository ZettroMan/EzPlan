package ru.gb.zettro.ezplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.zettro.ezplan.entities.Task;
import ru.gb.zettro.ezplan.entities.User;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.user = ?1")
    List<Task> findAllUserTasks(User user);

    @Query(value = "SELECT * FROM tasks t WHERE t.user_id = ?1 AND t.id NOT IN (SELECT child_id FROM tasks_descendants)", nativeQuery = true)
    List<Task> findAllUserRootTasks(User user);

}
