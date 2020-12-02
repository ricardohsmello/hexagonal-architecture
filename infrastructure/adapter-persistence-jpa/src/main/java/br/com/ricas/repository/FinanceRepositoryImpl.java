package br.com.ricas.repository;

import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.enums.FinanceType;
import br.com.ricas.mapper.FinanceMapper;
import br.com.ricas.model.Finance;
import br.com.ricas.port.FinancePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class FinanceRepositoryImpl implements FinancePort {

    private final FinanceRepository financeRepository;

    @Override
    public Optional<Finance> save(Finance finance) {
        log.info("Initializing finance save");
        return Optional.of(FinanceMapper.toFinance(financeRepository.save(FinanceMapper.toFinanceEntity(finance))));
    }

    @Override
    public Optional<List<Finance>> findAll() {
        log.info("Finding all sorted finances");
        return Optional.of(FinanceMapper.toListFinance(financeRepository.findAll(Sort.by("description"))));
    }

    @Override
    public Optional<List<Finance>> findAllByType(FinanceType type) {
        log.info("Finding all finances by type");
        return Optional.of(FinanceMapper.toListFinance(financeRepository.findAllByType(type.ordinal())));
    }
}
