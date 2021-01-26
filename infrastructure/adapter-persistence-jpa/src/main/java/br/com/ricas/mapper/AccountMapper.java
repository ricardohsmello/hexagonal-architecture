package br.com.ricas.mapper;

import br.com.ricas.entity.AccountEntity;
import br.com.ricas.entity.FinanceEntity;
import br.com.ricas.model.Account;
import br.com.ricas.model.Finance;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class AccountMapper {

    public AccountEntity toAccountEntity(Account account) {
        account.validateProperties(account);

        AccountEntity build = AccountEntity.builder()
                .name(account.getName())
                .balance(account.getBalance())
                .build();

        if (account.getUUID() !=null)
            build.setUUID(UUID.fromString(account.getUUID()));

        return build;
    }

    public Account toAccount(AccountEntity accountEntity) {
        Account build = new Account.Builder()
                .name(accountEntity.getName())
                .balance(accountEntity.getBalance())
                .build();

        build.setUUID(String.valueOf(accountEntity.getUUID()));

        return build;
    }

    public List<Account> toListAccount(final List<AccountEntity> list) {
        List<Account> listAccount = new ArrayList<>();

        list.forEach(accountEntity -> {
            listAccount.add(toAccount(accountEntity));
        });

        return listAccount;
    }

}
