package br.com.ricas.model;

import br.com.ricas.enums.FinanceType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceTests {

    @Test
    void shouldCreateFinanceWithExpenseType() {
        Finance finance = Finance.builder()
                .category(Category.builder()
                        .type(FinanceType.EXPENSE.ordinal())
                        .build())
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithRevenueType() {
        Finance finance = Finance.builder()
                .category(Category.builder()
                        .type(FinanceType.REVENUE.ordinal())
                        .build())
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithAValue() {
        Finance finance = Finance.builder()
                .value(250d)
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithACategory() {
        Finance finance = Finance.builder()
                .category(new Category(String.valueOf(UUID.randomUUID()), "Gasolina", 0))
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithADescription() {
        Finance finance = Finance.builder()
                .description("Test")
                .build();
        assertNotNull(finance);
    }

    @Test
    void testFinanceDataFinanceBuilder() {
        Finance finance = Finance.builder()
                .category(Category.builder()
                        .type(FinanceType.REVENUE.ordinal())
                        .build())
                .description("Test")
                .value(250d)
                .build();

        assertNotNull(finance.getDescription());
        assertTrue(finance.getCategory().getType()>=0);
        assertTrue(finance.getValue() > 0);
        assertNotNull(finance.getCategory());
    }
}

