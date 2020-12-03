package br.com.ricas.usecase;

import br.com.ricas.enums.FinanceType;
import br.com.ricas.exceptions.FieldException;
import br.com.ricas.model.Finance;
import br.com.ricas.port.AccountPort;
import br.com.ricas.port.CategoryPort;
import br.com.ricas.port.FinancePort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FinanceUseCase {

    FinancePort financePort;
    CategoryPort categoryPort;
    AccountPort accountPort;

    public Optional<Finance> save(Finance finance) throws FieldException {
        finance.validate();
        prepareFinanceDependency(finance);
        return financePort.save(finance);
    }

    private void prepareFinanceDependency(Finance finance) {
        finance.setCategory(categoryPort.findOrCreate(finance.getCategory()));
        finance.setAccount(accountPort.findOrCreate(finance.getAccount()));
    }

    public Optional<List<Finance>> findAll() {
        return financePort.findAll();
    }

    public Optional<List<Finance>> findAllByType(FinanceType type) {
        return financePort.findAllByType(type);
    }

}
