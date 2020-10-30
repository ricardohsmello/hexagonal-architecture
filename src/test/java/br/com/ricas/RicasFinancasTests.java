package br.com.ricas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class RicasFinancasTests {

    @Test
    void testMainApplication() {
        try {
            RicasFinancasApplication.main(new String[] {});
        } catch (Exception e) {
            fail(e);
        }
    }
}

