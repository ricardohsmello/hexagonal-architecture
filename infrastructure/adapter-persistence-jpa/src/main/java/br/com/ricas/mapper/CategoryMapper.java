package br.com.ricas.mapper;

import br.com.ricas.entity.AccountEntity;
import br.com.ricas.entity.CategoryEntity;
import br.com.ricas.model.Account;
import br.com.ricas.model.Category;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
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
        Category build = Category.builder()
                .name(categoryEntity.getName())
                .type(categoryEntity.getType())
                .build();

        build.setUUID(String.valueOf(categoryEntity.getUUID()));

        return build;
    }

    public List<Category> toListCategory(final List<CategoryEntity> list) {
        List<Category> listCategory = new ArrayList<>();

        list.forEach(categoryEntity -> {
            listCategory.add(toCategory(categoryEntity));
        });

        return listCategory;
    }

}
