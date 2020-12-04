package br.com.ricas.usecase;

import br.com.ricas.exceptions.FieldException;
import br.com.ricas.model.Account;
import br.com.ricas.port.AccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AccountUseCase {

    private final AccountPort accountPort;

    public Optional<List<Account>> findAll() {
        return accountPort.findAll();
    }

    public Optional<Account> save(Account account) throws FieldException {
        return accountPort.save(account);
    }
}
