package br.com.ricas.usecase;

import br.com.ricas.model.Category;
import br.com.ricas.port.CategoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class CategoryUseCase {

    private CategoryPort categoryPort;

    public Optional<Category> findByName(String name) {
        log.info("Initializing findByName: " + name);

        return categoryPort.findByName(name);
    }
}
