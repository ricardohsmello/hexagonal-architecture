package br.com.ricas.repository;

import br.com.ricas.mapper.CategoryMapper;
import br.com.ricas.model.Category;
import br.com.ricas.port.CategoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryPort {

    private final CategoryRepositoryJpa jpa;

    @Override
    public Optional<Category> findByName(String name) {
        return jpa.findByName(name);
    }

    @Override
    public Category findOrCreate(Category category) {
        if (isUUIDpresentInTheCategory(category)) {
            Category categoryFind = findCategoryByUUID(UUID.fromString(category.getUUID()));

            if (categoryFind != null) {
                return categoryFind;
            }
        }

        return createCategory(category);
    }

    private boolean isUUIDpresentInTheCategory(Category category) {
        return category.getUUID() != null && !String.valueOf(category.getUUID()).isEmpty();
    }

    private Category createCategory(Category category) {
        return CategoryMapper.toCategory(jpa.save(CategoryMapper.toCategoryEntity(category)));
    }

    private Category findCategoryByUUID(UUID uuid) {
        return jpa.findById(uuid).map(CategoryMapper::toCategory).orElse(null);
    }
}