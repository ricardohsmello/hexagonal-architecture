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
        prepareFinanceDependency(finance);
        return financePort.save(finance);
    }

    private void prepareFinanceDependency(Finance finance) throws FieldException {
        validateDependencies(finance);

        finance.setCategory(categoryPort.findOrCreate(finance.getCategory()));
        finance.setAccount(accountPort.findOrCreate(finance.getAccount()));
    }

    private void validateDependencies(Finance finance) {
        if (finance.getCategory() == null)
            throw new FieldException("Property Category can't be null");

        if (finance.getAccount() == null)
            throw new FieldException("Property Account can't be null");
    }

    public Optional<List<Finance>> findAll() {
        return financePort.findAll();
    }

    public Optional<List<Finance>> findAllByType(FinanceType type) {
        return financePort.findAllByType(type);
    }

}
