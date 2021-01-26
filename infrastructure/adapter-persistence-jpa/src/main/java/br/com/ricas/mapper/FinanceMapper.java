package br.com.ricas.mapper;

import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.model.Finance;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class FinanceMapper {

    public FinanceEntity toFinanceEntity(final Finance finance) {
        finance.validateProperties(finance);

        FinanceEntity build = FinanceEntity.builder()
                .UUID(UUID.randomUUID())
                .description(finance.getDescription())
                .dateTime(finance.getDateTime())
                .category(CategoryMapper.toCategoryEntity(finance.getCategory()))
                .account(AccountMapper.toAccountEntity(finance.getAccount()))
                .value(finance.getValue())
                .build();

        return build;
    }

    public Finance toFinance(final FinanceEntity financeEntity) {
        Finance build = new Finance.Builder()
                .description(financeEntity.getDescription())
                .dateTime(financeEntity.getDateTime())
                .category(CategoryMapper.toCategory(financeEntity.getCategory()))
                .account(AccountMapper.toAccount(financeEntity.getAccount()))
                .value(financeEntity.getValue())
                .build();

        build.setUUID(String.valueOf(financeEntity.getUUID()));
        return build;
    }

    public List<Finance> toListFinance(final List<FinanceEntity> list) {
        List<Finance> listFinance = new ArrayList<>();
        list.forEach(financeEntity -> listFinance.add(toFinance(financeEntity)));
        return listFinance;
    }

    public List<FinanceEntity> toListFinanceEntity(final List<Finance> list) {
        List<FinanceEntity> listFinance = new ArrayList<>();
        list.forEach(finance -> listFinance.add(toFinanceEntity(finance)));
        return listFinance;
    }
}
