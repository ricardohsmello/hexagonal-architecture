package br.com.ricas.repository.category;

import br.com.ricas.entity.CategoryEntity;
import br.com.ricas.mapper.CategoryMapper;
import br.com.ricas.model.Category;
import br.com.ricas.port.CategoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
@Slf4j
public class CategoryRepositoryImpl implements CategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> save(Category category) {
        log.info("Initializing category save");
        return Optional.of(CategoryMapper.toCategory(categoryRepository.save(CategoryMapper.toCategoryEntity(category))));
    }

    @Override
    public Optional<Category> findByName(String name) {
        log.info("Initializing category findByName");
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findOrCreate(Category category) {
        log.info("Initializing category findOrCreate");

        if (isUUIDpresent(category)) {
            Category categoryFind = findCategoryByUUID(UUID.fromString(category.getUUID()));

            if (categoryFind != null) {
                return categoryFind;
            }
        }

        return createCategory(category);
    }

    @Override
    public Optional<List<Category>> findAll() {
        log.info("Initializing category findAll");
        return Optional.of(CategoryMapper.toListCategory(categoryRepository.findAll(Sort.by("name"))));
    }

    private boolean isUUIDpresent(Category category) {
        return category.getUUID() != null && !String.valueOf(category.getUUID()).isEmpty();
    }

    private Category createCategory(Category category) {
        return CategoryMapper.toCategory(categoryRepository.save(CategoryMapper.toCategoryEntity(category)));
    }

    private Category findCategoryByUUID(UUID uuid) {
        return categoryRepository.findById(uuid).map(CategoryMapper::toCategory).orElse(null);
    }
}