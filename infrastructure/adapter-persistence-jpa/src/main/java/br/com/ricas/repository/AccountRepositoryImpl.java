package br.com.ricas.repository;

import br.com.ricas.mapper.AccountMapper;
import br.com.ricas.model.Account;
import br.com.ricas.port.AccountPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
 public class AccountRepositoryImpl implements AccountPort {

    private AccountRepository accountRepository;

    @Override
    public Optional<Account> save(Account account) {
        return Optional.of(AccountMapper.toAccount(accountRepository.save(AccountMapper.toAccountEntity(account))));
    }

    @Override
    public Optional<Account> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return AccountMapper.toListAccount(accountRepository.findAll(Sort.by("name")));
    }
}
