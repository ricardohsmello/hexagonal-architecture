package br.com.ricas.repository.category;

import br.com.ricas.mapper.CategoryMapper;
import br.com.ricas.model.Category;
import br.com.ricas.port.CategoryPort;
import br.com.ricas.util.BaseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

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
    public Category findOrCreate(Category category) {
//        log.info("Initializing category findOrCreate");
//        Optional<Category> optionalCategory =
//                Optional.of(findCategoryByUUID(UUID.fromString(category.getUUID()))).filter(BaseModel::hasUUID).or(() -> Optional.of(category));

        Optional.of(category);

        return category1;
//        return Optional.of(category).orElseGet();

//        return optionalCategory.get();

//        Optional<Boolean> aBoolean = Optional.of(category.hasUUID());
//        aBoolean.ifPresentOrElse(return findCategoryByUUID(UUID.fromString(category.getUUID())));
//
//        if (category.hasUUID()) {
////            Category categoryFind = findCategoryByUUID(UUID.fromString(category.getUUID()));
//
//            if (categoryFind != null) {
//                return categoryFind;
//            }
//        }

//        return category;
    }

    @Override
    public Optional<List<Category>> findAll() {
        log.info("Initializing category findAll");
        return Optional.of(CategoryMapper.toListCategory(categoryRepository.findAll(Sort.by("name"))));
    }

    private Category findCategoryByUUID(UUID uuid) {
        return categoryRepository.findById(uuid).map(CategoryMapper::toCategory).orElse(null);
    }
}