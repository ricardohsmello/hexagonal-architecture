package br.com.ricas.port;

import br.com.ricas.model.Account;
import br.com.ricas.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPort {

    Optional<Category> save(Category category);
    Optional<Category> findByName(String name);
    Category findOrCreate(Category category);
    List<Category> findAll();

}

