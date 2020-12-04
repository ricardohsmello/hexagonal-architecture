package br.com.ricas.controller.account.dto;

import br.com.ricas.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequest {

    String uuid;
    String name;
    Double balance;

    public Account transformToObject() {
        return new Account.Builder()
                .name(name)
                .balance(balance)
                .build();
    }
}
