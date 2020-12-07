package ru.gb.zettro.ezplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.zettro.ezplan.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
