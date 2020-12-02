package br.com.ricas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTests {

    private Account.AccountBuilder account;

    @BeforeEach
    public void init() {
        account = Account.builder();
    }

    @Test
    public void should_create_account_name() {
        account.name("Santander");
        assertEquals("Santander", account.build().getName());
    }

    @Test
    public void should_create_balance() {
        account.balance(2500.0);
        assertEquals(2500.0, account.build().getBalance());
    }
}
