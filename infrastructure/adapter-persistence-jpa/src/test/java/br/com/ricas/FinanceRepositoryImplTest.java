package br.com.ricas;

import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.enums.FinanceType;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import br.com.ricas.repository.FinanceRepositoryImpl;
import br.com.ricas.repository.FinanceRepositoryJpa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FinanceRepositoryImplTest {

    @InjectMocks
    FinanceRepositoryImpl financeRepositoryImpl;

    @Mock
    private FinanceRepositoryJpa jpa;

    @Test
    public void shouldPersistFinance() {
        var finance = Finance.builder()
                .category(Category
                        .builder()
                        .name("Internet")
                        .type(FinanceType.EXPENSE.ordinal())
                        .build())
                .value(99.9)
                .description("Fatura da internet")
                .UUID(UUID.randomUUID())
                .build();

        var financeEntity = mock(FinanceEntity.class);
        when(financeEntity.getUUID()).thenReturn(UUID.randomUUID());

        when(jpa.save(any())).thenReturn(financeEntity);

        financeRepositoryImpl.save(finance);

        verify(jpa).save(any());
    }
}
