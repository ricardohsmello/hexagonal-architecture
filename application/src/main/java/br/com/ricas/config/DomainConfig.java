package br.com.ricas.config;

import br.com.ricas.port.AccountPort;
import br.com.ricas.port.CategoryPort;
import br.com.ricas.port.FinancePort;
import br.com.ricas.usecase.AccountUseCase;
import br.com.ricas.usecase.CategoryUseCase;
import br.com.ricas.usecase.FinanceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public FinanceUseCase financeUseCase(FinancePort financePort, CategoryPort categoryPort) {
        return new FinanceUseCase(financePort, categoryPort);
    }
    @Bean
    public CategoryUseCase categoryUseCase(CategoryPort categoryPort) {
        return new CategoryUseCase(categoryPort);
    }

    @Bean
    public AccountUseCase accountUseCase(AccountPort accountPort) {
        return new AccountUseCase(accountPort);
    }

}
