package br.com.ricas.repository.account;

import br.com.ricas.mapper.AccountMapper;
import br.com.ricas.model.Account;
import br.com.ricas.port.AccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
 public class AccountRepositoryImpl implements AccountPort {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> save(Account account) {
        log.info("Initializing account save");
        return Optional.of(AccountMapper.toAccount(accountRepository.save(AccountMapper.toAccountEntity(account))));
    }

    @Override
    public Optional<Account> findById(UUID uuid) {
        log.info("Initializing account findById");
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        log.info("Initializing account findAll");
        return AccountMapper.toListAccount(accountRepository.findAll(Sort.by("name")));
    }

    @Override
    public Account findOrCreate(Account account) {
        log.info("Initializing account findOrCreate");

        if (isUUIDpresent(account)) {
            Account accountFind = accountRepository.findById(UUID.fromString(account.getUUID())).map(AccountMapper::toAccount).orElse(null);

            if (accountFind != null) {
                return accountFind;
            }
        }
        return createAccount(account);
    }

    private boolean isUUIDpresent(Account account) {
        return account.getUUID() != null && !String.valueOf(account.getUUID()).isEmpty();
    }

    private Account createAccount(Account account) {
        return AccountMapper.toAccount(accountRepository.save(AccountMapper.toAccountEntity(account)));
    }

}