package ru.gb.zettro.ezplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.registry.Registry;
import ru.gb.zettro.ezplan.viewdto.CategoryView;

import java.util.List;
import java.util.Optional;

public class CategoryRepository implements Repository<Category> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Category> findById(Long id) {
        Category category = Registry.getInstance().getIdentityMap().findCategory(id);
        if (category != null) return Optional.of(category);
        CategoryView view = jdbcTemplate.query(
                "select c.id, c.name, c.color, u.id, u.username" +
                        " from categories c" +
                        " join users u on c.userId = u.id" +
                        " where c.id = ?",
                (r, i) -> CategoryView.builder()
                        .id(r.getLong(1))
                        .name(r.getString(2))
                        .color(r.getString(3))
                        .userId(r.getLong(4))
                        .username(r.getString(5))
                        .build(),
                id
        ).stream().findAny().orElse(null);
        if (view != null) { // если не null - добавляем в кэш
            category = mapCategory(view);
            Registry.getInstance().getIdentityMap().addCategory(category);
        }
        return Optional.of(category);
    }

    private Category mapCategory(CategoryView view) {
        return Category.builder()
                .id(view.getId())
                .name(view.getName())
                .color(view.getColor())
                .user(mapUser(view))
                .build();
    }

    private User mapUser(CategoryView view) {
        return User.builder()
                .id(view.getUserId())
                .username(view.getUsername())
                .build();
    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }


}
