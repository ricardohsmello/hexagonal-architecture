package br.com.ricas.controller.category.dto;

import br.com.ricas.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryRequest {
    private String UUID;
    private String name;
    private Integer type;

    public Category transformToObject() {
        return new Category.Builder()
                .name(name)
                .type(type)
                .build();
    }
}

