package br.com.ricas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryTests {

    @Test
    void shouldCreateACategoryWithName() {
        Category category = new Category();
        category.setName("Internet");

        assertNotNull(category.getName());
    }
}
