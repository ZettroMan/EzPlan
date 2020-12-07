package ru.gb.zettro.ezplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.zettro.ezplan.entities.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer> {
}
