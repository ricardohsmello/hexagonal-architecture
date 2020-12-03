package br.com.ricas.controller.category.dto;

import br.com.ricas.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryRequest {
    private String UUID;
    private String name;
    private int type;

    public Category transformToObject() {
        return Category.builder()
                .name(name)
                .type(type)
                .build();
    }
}

