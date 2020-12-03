package br.com.ricas.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryTests {

    @Test
    void shouldCreateACategoryWithName() {
        Category category = new Category("f93f0226-dcfa-4a6d-bc80-94aca858a9fc", "Gasolina", 0);
        category.setName("Internet");

        assertNotNull(category.getName());
    }
}
