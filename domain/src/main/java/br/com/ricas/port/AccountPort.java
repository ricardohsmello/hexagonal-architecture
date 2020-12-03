package br.com.ricas.port;

import br.com.ricas.model.Account;
import br.com.ricas.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountPort {

    Optional<Account> save(Account account);
    Optional<Account> findById(UUID uuid);
    List<Account> findAll();
    Account findOrCreate(Account account);
}
