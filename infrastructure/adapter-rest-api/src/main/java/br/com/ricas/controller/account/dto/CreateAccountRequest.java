package br.com.ricas.controller.account.dto;

import br.com.ricas.model.Account;
import br.com.ricas.model.Category;
import br.com.ricas.model.Finance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountRequest {

    String uuid;
    String name;
    double balance;

    public Account transformToObject() {
        return Account.builder()
                .name(name)
                .balance(balance)
                .build();
    }
}
