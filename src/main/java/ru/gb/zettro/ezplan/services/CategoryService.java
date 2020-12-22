package ru.gb.zettro.ezplan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.dtos.CategoryDto;
import ru.gb.zettro.ezplan.entities.Category;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.repositories.CategoryRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static final Function<Category, CategoryDto> CategoryToDto = category -> {
        return new CategoryDto().builder()
                .id(category.getId())
                .name(category.getName())
                .color(category.getColor())
                .build();
    };

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAllUserCategories(User user) {
        return categoryRepository.findAllUserCategories(user).stream().map(CategoryToDto).collect(Collectors.toList());
    }
}
