package br.com.ricas.repository;

import br.com.ricas.mapper.FinanceMapper;
import br.com.ricas.model.Finance;
import br.com.ricas.port.PersistentFinancePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FinanceRepositoryImpl implements PersistentFinancePort {

    private final FinanceRepositoryJpa jpa;

    @Override
    public Finance save(Finance finance) {
        return FinanceMapper.toFinance(jpa.save(FinanceMapper.toFinanceEntity(finance)));
    }
}
