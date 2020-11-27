package br.com.ricas.mapper;

import br.com.ricas.entity.CategoryEntity;
import br.com.ricas.model.Category;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class CategoryMapper {

    public CategoryEntity toCategoryEntity(Category category) {
        CategoryEntity build = CategoryEntity.builder()
                .name(category.getName())
                .type(category.getType())
                .build();

        if (category.getUUID() !=null)
            build.setUUID(UUID.fromString(category.getUUID()));

        return build;

    }

    public Category toCategory(CategoryEntity categoryEntity) {
        return Category.builder()
                .UUID(String.valueOf(categoryEntity.getUUID()))
                .name(categoryEntity.getName())
                .type(categoryEntity.getType())
                .build();
    }
}
