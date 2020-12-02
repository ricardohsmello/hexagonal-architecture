package br.com.ricas.controller.account.dto;

import br.com.ricas.exceptions.AccountException;
import br.com.ricas.model.Account;
import br.com.ricas.usecase.AccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author ricardo.mello
 */
@RestController
@RequestMapping("api/accounts")
@AllArgsConstructor
public class AccountController {

    AccountUseCase accountUseCase;

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<CreateAccountResponse> add(@RequestBody CreateAccountRequest createAccountRequest) {
        try {
            Optional<Account> account = accountUseCase.save(createAccountRequest.transformToObject());

            if (account.isEmpty())
                throw new AccountException("Account was not created");

            CreateAccountResponse accountResponse = CreateAccountResponse
                    .builder()
                    .UUID(UUID.fromString(account.get().getUUID()))
                    .name(account.get().getName())
                    .build();

            return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
        } catch (AccountException e) {
            throw new AccountException(e.getMessage());
        }
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(accountUseCase.findAll(), HttpStatus.OK);
    }
}