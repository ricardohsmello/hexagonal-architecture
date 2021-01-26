package br.com.ricas.model;

import br.com.ricas.util.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseModel<Account> {

    private String name;
    private Double balance;

    public static class Builder {

        Account account;

        public Builder() {
            account = new Account();
        }

        public Account.Builder UUID(String UUID) {
            this.account.setUUID(UUID);
            return this;
        }


        public Account.Builder name(String name) {
            this.account.setName(name);
            return this;
        }

        public Account.Builder balance(Double balance) {
            this.account.setBalance(balance);
            return this;
        }

        public Account build() {
            return new Account(this.account.getName(), this.account.getBalance());
        }
    }

}
