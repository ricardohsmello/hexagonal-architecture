package br.com.ricas.adapter;

import br.com.ricas.FinanceEntity;
import br.com.ricas.model.Finance;
import br.com.ricas.ports.FinanceServicePort;
import br.com.ricas.repository.FinanceRepository;
import org.springframework.beans.BeanUtils;

public class FinanceJpaAdapter implements FinanceServicePort {

    private FinanceRepository financeRepository;

    public FinanceJpaAdapter(FinanceRepository financeRepository){
        this.financeRepository = financeRepository;
    }

    @Override
    public void save(Finance finance) {
        FinanceEntity financeEntity = new FinanceEntity();
        BeanUtils.copyProperties(finance, financeEntity);
        financeRepository.save(financeEntity);
    }
}
