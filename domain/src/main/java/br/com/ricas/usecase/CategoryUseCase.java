package br.com.ricas.usecase;

import br.com.ricas.exceptions.FieldException;
import br.com.ricas.model.Category;
import br.com.ricas.port.CategoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CategoryUseCase {

    private final CategoryPort categoryPort;

    public Optional<Category> findByName(String name) {
        return categoryPort.findByName(name);
    }

    public Optional<List<Category>> findAll() {
        return categoryPort.findAll();
    }

    public Optional<Category> save(Category category) throws FieldException {
        return categoryPort.save(category);
    }
}
