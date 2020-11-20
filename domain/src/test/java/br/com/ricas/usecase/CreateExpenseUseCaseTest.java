package br.com.ricas.usecase;


import br.com.ricas.model.Finance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateExpenseUseCaseTest {

    @Test
    public void shouldCreateAExpenseTest() throws Exception {
        CreateExpenseUseCase create = new CreateExpenseUseCase(null);
        Finance finance = new Finance();
        Assertions.assertNotNull(create.execute(finance));
    }
}
