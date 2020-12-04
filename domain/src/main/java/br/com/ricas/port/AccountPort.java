package br.com.ricas.port;

import br.com.ricas.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountPort {

    Optional<Account> save(Account account);
    Account findOrCreate(Account account);
    Optional<List<Account>> findAll();
}
