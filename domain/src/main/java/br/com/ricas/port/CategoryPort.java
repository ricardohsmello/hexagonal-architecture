package br.com.ricas.port;

import br.com.ricas.model.Category;

import java.util.Optional;
import java.util.UUID;

public interface CategoryPort {

    Optional<Category> findByName(String name);
    Category findOrCreate(Category category);
}

