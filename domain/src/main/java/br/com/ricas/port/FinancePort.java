package br.com.ricas.port;

import br.com.ricas.enums.FinanceType;
import br.com.ricas.model.Finance;

import java.util.List;
import java.util.Optional;

public interface FinancePort {
    Optional<Finance> save(Finance finance);
    Optional<List<Finance>> findAllByType(FinanceType type);
    Optional<List<Finance>> findAll();
}
