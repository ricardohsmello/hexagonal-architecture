package br.com.ricas.controller.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CategoryResponse {

    private UUID UUID;
    private String name;

}
