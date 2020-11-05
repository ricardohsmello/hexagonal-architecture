package br.com.ricas.configuration;

import br.com.ricas.adapter.FinanceJpaAdapter;
import br.com.ricas.ports.FinanceServicePort;
import br.com.ricas.repository.FinanceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FinanceServicePort getFinanceServicePort(FinanceRepository financeRepository) {
        return new FinanceJpaAdapter(financeRepository);
    }

}