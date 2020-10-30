package br.com.ricas.model;

import br.com.ricas.FinanceType;
import br.com.ricas.RicasFinancasApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceTests {

    private Finance.Builder builder;

    @BeforeEach
    void initialize() {
        builder = new Finance.Builder();
    }

    @Test
    void testMainApplication() {
        try {
            RicasFinancasApplication.main(new String[] {});
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void shouldCreateFinanceWithExpenseType() {
        Finance finance = builder
                .type(FinanceType.EXPENSE)
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithRevenueType() {
        Finance finance = builder
                .type(FinanceType.REVENUE)
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithAValue() {
        Finance finance = builder
                .value(250d)
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithACategory() {
        Finance finance = builder
                .category(new Category())
                .build();
        assertNotNull(finance);
    }

    @Test
    void shouldCreateFinanceWithADescription() {
        Finance finance = builder
                .description("Test")
                .build();
        assertNotNull(finance);
    }

    @Test
    void testFinanceDataBuilder() {
        Finance finance = builder
                .type(FinanceType.REVENUE)
                .category(new Category())
                .description("Test")
                .value(250d)
                .build();

        assertNotNull(finance.getDescription());
        assertNotNull(finance.getType());
        assertTrue(finance.getValue() > 0);
        assertNotNull(finance.getCategory());
    }
}

