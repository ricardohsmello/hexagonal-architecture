package br.com.ricas.usecase;

import br.com.ricas.model.Finance;
import br.com.ricas.port.PersistentFinancePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateExpenseUseCase {

    PersistentFinancePort savePort;

    public Finance execute(Finance finance) throws Exception {
        validate(finance);
        log.info("Iniciando save");
        return savePort.save(finance);
    }

    private void validate(Finance finance) throws Exception {
        if (finance==null) {
            throw new Exception("");
        }
    }
}
