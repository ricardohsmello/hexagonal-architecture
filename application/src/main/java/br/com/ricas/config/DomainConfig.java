package br.com.ricas.config;

import br.com.ricas.port.PersistentFinancePort;
import br.com.ricas.usecase.CreateExpenseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public CreateExpenseUseCase createExpenseUseCase(PersistentFinancePort persistentFinancePort) {
        return new CreateExpenseUseCase(persistentFinancePort);
    }
}
