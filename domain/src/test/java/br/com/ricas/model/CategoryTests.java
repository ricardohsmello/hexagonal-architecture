package br.com.ricas.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryTests {

    @Test
    void shouldCreateACategoryWithName() {
        Category category = new Category(String.valueOf(UUID.randomUUID()), "Gasolina", 0);
        category.setName("Internet");

        assertNotNull(category.getName());
    }
}
