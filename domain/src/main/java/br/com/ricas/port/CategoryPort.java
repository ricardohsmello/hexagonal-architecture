package br.com.ricas.port;

import br.com.ricas.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPort {

    Optional<Category> save(Category category);
    Category findOrCreate(Category category);
    Optional<List<Category>> findAll();
    Optional<Category> findByName(String name);

}

