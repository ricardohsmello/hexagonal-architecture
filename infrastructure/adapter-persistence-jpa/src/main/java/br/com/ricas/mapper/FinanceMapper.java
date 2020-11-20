package br.com.ricas.mapper;

import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.model.Finance;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FinanceMapper {

    public FinanceEntity toFinanceEntity(final Finance finance) {
        return FinanceEntity.builder()
                .description(finance.getDescription())
                .value(finance.getValue())
                .build();
    }

    public Finance toFinance(final FinanceEntity financeEntity) {
        return new Finance.Builder()
                .description(financeEntity.getDescription())
                .value(financeEntity.getValue())
                .build();
    }
}
