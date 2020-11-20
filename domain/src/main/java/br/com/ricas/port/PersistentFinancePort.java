package br.com.ricas.port;

import br.com.ricas.model.Finance;

public interface PersistentFinancePort {
    Finance save(Finance finance);
}
