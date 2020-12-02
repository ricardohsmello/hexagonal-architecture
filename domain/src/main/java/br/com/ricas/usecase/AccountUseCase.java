package br.com.ricas.usecase;

import br.com.ricas.exceptions.AccountException;
import br.com.ricas.model.Account;
import br.com.ricas.port.AccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class AccountUseCase {

    private final AccountPort accountPort;

    public List<Account> findAll() {
        log.info("Finding all accounts");
        return accountPort.findAll();
    }

    public Optional<Account> save(Account account) throws AccountException {
//        account.isInvalid();
        return accountPort.save(account);
    }
}
