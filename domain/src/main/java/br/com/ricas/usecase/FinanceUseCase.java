package br.com.ricas.usecase;

import br.com.ricas.enums.FinanceType;
import br.com.ricas.exceptions.FinanceException;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import br.com.ricas.port.CategoryPort;
import br.com.ricas.port.FinancePort;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class FinanceUseCase {

    FinancePort financePort;
    CategoryPort categoryPort;

    public FinanceUseCase (FinancePort financePort, CategoryPort categoryPort) {
        this.financePort = financePort;
        this.categoryPort = categoryPort;
     }

    public Optional<Finance> save(Finance finance) throws FinanceException {
        finance.isInvalid();
        Category category = categoryPort.findOrCreate(finance.getCategory());
        finance.setCategory(category);
        return financePort.save(finance);
    }

    public Optional<List<Finance>> findAll() {
        return financePort.findAll();
    }

    public Optional<List<Finance>> findAllByType(FinanceType type) {
        return financePort.findAllByType(type);
    }
}
