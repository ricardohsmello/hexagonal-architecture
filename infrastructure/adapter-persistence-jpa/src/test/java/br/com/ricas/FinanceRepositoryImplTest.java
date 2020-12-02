package br.com.ricas;

import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.enums.FinanceType;
import br.com.ricas.mapper.FinanceMapper;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import br.com.ricas.repository.FinanceRepository;
import br.com.ricas.repository.FinanceRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class FinanceRepositoryImplTest {

    @Mock
    private FinanceRepository financeRepository;

    @InjectMocks
    private FinanceRepositoryImpl financeRepositoryImpl;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_persist_finance() {
        given(financeRepository.save(any(FinanceEntity.class))).will(ret -> ret.getArgument(0));
        Finance finance = createFinance("Internet");
        financeRepositoryImpl.save(finance);
        verify(financeRepository, times(1)).save(FinanceMapper.toFinanceEntity(finance));
    }

    @Test
    public void test_list_all_finance() {
        List<Finance> list = new ArrayList<>();
        list.add(createFinance("Internet"));
        list.add(createFinance("Gas"));
        list.add(createFinance("Car"));

        given(financeRepository.findAll()).willReturn(FinanceMapper.toListFinanceEntity(list));
        given(financeRepository.count()).willReturn((long) list.size());
    }

    private Finance createFinance(String description) {
        var finance = Finance.builder()
                .category(Category
                        .builder()
                        .name(description)
                        .UUID("44551690-954e-4b47-b555-ad6b3df31099")
                        .type(FinanceType.EXPENSE.ordinal())
                        .build())
                .value(99.9)
                .description("Fatura da internet")
                .UUID(UUID.randomUUID().toString())
                .build();
        return finance;
    }
}
