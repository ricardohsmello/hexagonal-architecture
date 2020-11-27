package br.com.ricas.repository;

import br.com.ricas.mapper.FinanceMapper;
import br.com.ricas.model.Finance;
import br.com.ricas.port.FinancePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class FinanceRepositoryImpl implements FinancePort {

    private final FinanceRepositoryJpa jpa;

    @Override
    public Optional<Finance> save(Finance finance) {
        log.info("Initializing save");
        return Optional.of(FinanceMapper.toFinance(jpa.save(FinanceMapper.toFinanceEntity(finance))));
    }

    @Override
    public Optional<List<Finance>> getAll() {
        return Optional.empty();
    }
}
