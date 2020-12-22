package ru.gb.zettro.ezplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.User;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.user = ?1")
    List<Category> findAllUserCategories(User user);
}
