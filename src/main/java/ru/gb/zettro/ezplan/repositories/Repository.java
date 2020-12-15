package ru.gb.zettro.ezplan.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(Long id);

    T save(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();
}
