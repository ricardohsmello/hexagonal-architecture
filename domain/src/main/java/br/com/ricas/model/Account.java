package br.com.ricas.model;

import br.com.ricas.util.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseModel<Account> {

    private String UUID;
    private String name;
    private Double balance;

    public static class Builder {

//        Account account;

        String UUID;
        String name;
        Double balance;

        public Builder() {
//            account = new Account();
        }

        public Account.Builder UUID(String UUID){
//            this.account.setUUID(UUID);
            this.UUID=UUID;
            return this;
        }


        public Account.Builder name(String name){
//            this.account.setName(name);
            this.name = name;
            return this;
        }

        public Account.Builder balance(Double balance){
//            this.account.setBalance(balance);
            this.balance = balance;
            return this;
        }

        public Account build() {
//            Account account = new Account(this.account.getUUID(), this.account.getName(), this.account.getBalance());
            Account account = new Account(this.UUID, this.name, this.balance);
            account.validateProperties(account);
            return account;
        }


    }

}
